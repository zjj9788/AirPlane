package com.isoft.demo.airplane;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class GuideFragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_guide_fragment3, container, false);
    ImageButton btn=(ImageButton) view.findViewById(R.id.btn_img);
      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent();
              intent.setClass(getActivity(),LoginActivity.class);
              getActivity().startActivity(intent);
              getActivity().finish();
          }
      });
        return view;
    }

}
