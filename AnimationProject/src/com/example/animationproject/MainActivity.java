package com.example.animationproject;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LayoutTransition l = new LayoutTransition();
		l.enableTransitionType(LayoutTransition.CHANGING);
		ViewGroup viewGroup = (ViewGroup) findViewById(R.id.relLayout);
		viewGroup.setLayoutTransition(l);
		
		findViewById(R.id.relLayout).setOnTouchListener(new  OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
				Button button = (Button) findViewById(R.id.Button);
				button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
				//		pb.animate().translationY(-(pb.getWidth()*2));
						ObjectAnimator fadeOut = ObjectAnimator.ofFloat(pb, "alpha", 0f);
						fadeOut.setDuration(1000);
						fadeOut.addListener(new AnimatorListener() {
							
							@Override
							public void onAnimationStart(Animator animation) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void onAnimationRepeat(Animator animation) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void onAnimationEnd(Animator animation) {
								ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
								pb.setVisibility(View.GONE);
								
							}
							
							@Override
							public void onAnimationCancel(Animator animation) {
								// TODO Auto-generated method stub
								
							}
						});
						fadeOut.start();
						
					}
				});
				//pb.animate().translationY(pb.getWidth()*2);
				pb.setVisibility(View.VISIBLE);
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
