package com.taeksukim.android.fragmentcontrol;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


public class BlankFragment extends Fragment {

    private Listener mListener;

    RecyclerView recyclerView;

    String[] datas;




    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        //1. 리사이클러뷰 가져오기
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        //2. 아답터 생성
        ListAdapter adapter = new ListAdapter();

        //3. 뷰에 아답터 세팅
        recyclerView.setAdapter(adapter);

        //4. 레이아웃 매니저 세팅
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }



    //1. 인터페이스 선언
    //나를 호출하는 activity에서 구현해야되는 인터페이스
    public interface Listener {

        String[] getdata();
    }

    //프래그먼트가 Activity에서 호출되는 순간, 호출한 Actucuty의 context가 넘어온다.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //넘어온 context(Activity)가 Onfragment리스너의 구현체인지를 확인
        //instanceof : 타입 체크

        //넘어온 activity를 Listener로 캐스팅해서 mListener 변수에 담아둔다.
        //3. 사용하는 사용자 측에서 인터페이스 필터링
        mListener = (Listener) context;
        datas = mListener.getdata();


   }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //리사이클러뷰 아답터 생성
    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {



        @Override
        public ListAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(ListAdapter.Holder holder, int position) {
            String item = datas[position];
            holder.title.setText(item);

        }

        @Override
        public int getItemCount() {
            return datas.length;
        }

        class Holder extends RecyclerView.ViewHolder {
            TextView title;
            public Holder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.title);
            }
        }
    }
}

