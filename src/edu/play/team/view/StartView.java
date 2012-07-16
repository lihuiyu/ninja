package edu.play.team.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import edu.play.team.R;

public class StartView implements OnClickListener{

	private Context context;
	private LayoutInflater inflater;
	private View view;
	private ImageView start_item;
	private ImageView setting_item;
	
	public StartView(Context context){
		this.context=context;
		this.inflater=(LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public View getStartView() {
		
		view=inflater.inflate(R.layout.start_view_layout, null);
		start_item=(ImageView)view.findViewById(R.id.start_item);
		setting_item=(ImageView)view.findViewById(R.id.setting_item);
		start_item.setOnClickListener(this);
		setting_item.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		switch(id){
		case R.id.start_item:
			break;
		case R.id.setting_item:
			break;
		}	
	}
	
	 
	
	
	
}
