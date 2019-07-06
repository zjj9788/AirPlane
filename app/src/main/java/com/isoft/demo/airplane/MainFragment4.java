package com.isoft.demo.airplane;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment4 extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_fragment4, container, false);
        listView = (ListView) view.findViewById(R.id.personCenter);
        int[] img = {R.mipmap.logo, R.mipmap.logo, R.mipmap.logo, R.mipmap.logo};
        String[] label = {"aaaa", "bbbb", "cccc", "dddd"};
        String[] label1 = {"aaaa", "bbbb", "cccc", "dddd"};
        List data = new ArrayList();
        for (int i = 0; i < img.length; i++) {
            Map map = new HashMap();
            map.put("title", label[i]);
            map.put("title1", label[i]);
            map.put("img", img[i]);
            data.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),
                data, R.layout.my_fragment_sub,
                new String[]{"title", "title1", "img"}, new int[]{R.id.label, R.id.label1, R.id.img});
        listView.setAdapter(simpleAdapter);
        return view;
    }

}
