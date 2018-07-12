package com.course.course;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

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



	public static void main(String[] args) throws IOException, InterruptedException {
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
