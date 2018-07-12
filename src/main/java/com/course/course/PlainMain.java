package com.course.course;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlainMain {

	private static DatabaseReference ref;

	public static void main(String[] args) throws Exception {
		doJson();
	}


	private static void doJson() throws Exception {
		//String s = "{\"id\":\"37e4943f-1bac-40b4-b4a3-8b7ec7846d38\",\"timestamp\":\"2018-07-12T17:30:11.637Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"123\",\"speech\":\"\",\"action\":\"test\",\"actionIncomplete\":false,\"parameters\":{\"number\":123},\"contexts\":[],\"metadata\":{\"intentId\":\"2990cef5-c561-4f80-89bb-b7592951de32\",\"webhookUsed\":\"true\",\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"test\"},\"fulfillment\":{\"speech\":\"\",\"messages\":[{\"type\":0,\"speech\":\"\"}]},\"score\":1.0},\"status\":{\"code\":200,\"errorType\":\"success\"},\"sessionId\":\"140d9213-fc7e-0eee-547b-5a60ef91a4e3\"}";
		String s = "{\"id\":\"ebafb770-54c5-4763-a257-4cab69c2b705\",\"timestamp\":\"2018-07-12T17:51:45.668Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"1234\",\"speech\":\"\",\"action\":\"test\",\"actionIncomplete\":false,\"parameters\":{\"number\":\"1234\"},\"contexts\":[],\"metadata\":{\"intentId\":\"2990cef5-c561-4f80-89bb-b7592951de32\",\"webhookUsed\":\"true\",\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"test\"},\"fulfillment\":{\"speech\":\"\",\"messages\":[{\"type\":0,\"speech\":\"\"}]},\"score\":1.0},\"status\":{\"code\":200,\"errorType\":\"success\"},\"sessionId\":\"140d9213-fc7e-0eee-547b-5a60ef91a4e3\"}";
		JSONObject obj = new JSONObject(s);
		//JSONObject number = obj.getJSONObject("result").getJSONObject("parameters");
		String number = obj.getJSONObject("result").getJSONObject("parameters").getString("number");
		
		System.out.println("number="+number);
	}


	public static void main2(String[] args) throws IOException, InterruptedException {
		FileInputStream serviceAccount =
				  new FileInputStream("C:\\projects\\dominospizza-78e07-firebase-adminsdk-yh24y-d071d4aaa8.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://dominospizza-78e07.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
				
				
				final FirebaseDatabase database = FirebaseDatabase.getInstance();
				
				ref = database.getReference("users");
				
			
				CountDownLatch done = new CountDownLatch(1);
				
				// Attach a listener to read the data at our posts reference
				ref.addListenerForSingleValueEvent(new ValueEventListener() {
				  @Override
				  public void onDataChange(DataSnapshot dataSnapshot) {
					  Users users = dataSnapshot.getValue(Users.class);
				    System.out.println("onDataChange=" + users);
				  }
				  
				  

				  @Override
				  public void onCancelled(DatabaseError databaseError) {
				    System.out.println("The read failed: " + databaseError.getCode());
				  }
				});		
				
				done.await(); //it will wait till the response is received from firebase.
		System.out.println("Done..");

	}
	
	
	
	 public static void startListeners() {
	        ref.child("users").addChildEventListener(new ChildEventListener() {

	            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildName) {
	                final String postId = dataSnapshot.getKey();
	                final Users post = dataSnapshot.getValue(Users.class);
	                System.out.println("startListeners="+post);	
	                // Listen for changes in the number of stars and update starCount
	                //addStarsChangedListener(post, postId);

	                // Listen for new stars on the post, notify users on changes
	                //addNewStarsListener(dataSnapshot.getRef(), post);
	            }

	            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildName) {}

	            public void onChildRemoved(DataSnapshot dataSnapshot) {}

	            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildName) {}

	            public void onCancelled(DatabaseError databaseError) {
	                System.out.println("startListeners: unable to attach listener to posts");
	                System.out.println("startListeners: " + databaseError.getMessage());
	            }
	        });
	    }

}


class Users{
	
	private String first;
	private String last;
	
	public Users(String f, String l) {
		this.first = f;
		this.last = l;
	}
	
	public Users() {}
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	@Override
	public String toString() {
		return "first="+first+" ,last="+last;
	}
}
