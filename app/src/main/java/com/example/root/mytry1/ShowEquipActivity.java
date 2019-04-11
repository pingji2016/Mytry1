package com.example.root.mytry1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.root.mytry1.element.Dparameter;
import com.example.root.mytry1.element.Equipment;
import com.example.root.mytry1.element.EquipmentData;
import com.example.root.mytry1.element.Parameter;
import com.example.root.mytry1.element.User;
import com.example.root.mytry1.network.GetEquipService;
import com.example.root.mytry1.network.LoginService;
import com.example.root.mytry1.util.PrefUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 19-4-10.
 */

public class ShowEquipActivity extends AppCompatActivity {
    private String equipment;
    private String simulation;
    private Button save_local;
    private ListView parameter_list;
    private GetEquipService getequipservice;

    private static final String TAG = "ShowEquipActivity";

    private static EquipmentData simulation_data;
    private List<Dparameter> dp_data;
    private List<Parameter> p_data;//=new ArrayList<Parameter>()
    private HashMap<String,ImageView> item_parameter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment);

        Intent i =getIntent();
        equipment=i.getStringExtra("equipment");
        simulation=i.getStringExtra("simulation");

        simulation_data=new EquipmentData();

        serachonline();
        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //System.err("1356u");
        }

        initView();
    }

    private void initResources() {
//        mContentResolver = this.getContentResolver();
//        mBackgroundQueryHandler = new BackgroundQueryHandler(this.getContentResolver());
//        mCurrentFolderId = Notes.ID_ROOT_FOLDER;
//        parameter_list = (ListView) findViewById(R.id.notes_list);
//        parameter_list.addFooterView(LayoutInflater.from(this).inflate(R.layout.note_list_footer, null),
//                null, false);
//        parameter_list.setOnItemClickListener(new OnListItemClickListener());
//        parameter_list.setOnItemLongClickListener(this);
//        mNotesListAdapter = new NotesL istAdapter(this);
//        parameter_list.setAdapter(mNotesListAdapter);
//        mAddNewNote = (Button) findViewById(R.id.btn_new_note);
//        mAddNewNote.setOnClickListener(this);
//        mAddNewNote.setOnTouchListener(new NewNoteOnTouchListener());
//        mDispatch = false;
//        mDispatchY = 0;
//        mOriginY = 0;
//        mTitleBar = (TextView) findViewById(R.id.tv_title_bar);
//        mState = ListEditState.NOTE_LIST;
//        mModeCallBack = new ModeCallback();
    }

    private void initView() {
        ListView gridview = (ListView) findViewById(R.id.notes_list);
        ArrayList<String> imagelist = new ArrayList<String>();

        List <HashMap<String,String>> s2list=new ArrayList<HashMap<String,String>>();

        // 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
        // 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的
//        for (int i = 0; i < dp_data.size(); i++) {
//            String tmp=.get(i).getDparameter_name();
//            imagelist.add(tmp);
//        }

        if (simulation_data!=null) {
//            imagelist.add(simulation_data.getSimulation_name());
//            imagelist.add(simulation_data.getSimulation_create_time());
//            imagelist.add(simulation_data.getSimulation_create_user_id());
//            imagelist.add(simulation_data.getSimulation_update_time());
//            imagelist.add(simulation_data.getSimulation_update_user_id());

            HashMap<String,String> tmp=new HashMap<>();
            tmp.put("name",simulation_data.getSimulation_name());
            tmp.put("create-time",simulation_data.getSimulation_create_time());
            tmp.put("create-user",simulation_data.getSimulation_create_user_id());

            tmp.put("update-time",simulation_data.getSimulation_update_time());
            tmp.put("update-user",simulation_data.getSimulation_update_user_id());

            s2list.add(tmp);

            SimpleAdapter simpleAdapter=new SimpleAdapter(this,
                    s2list,
                    R.layout.notes_list_item1,
                    new String[]{"name","create-time","create-user","update-time","updaet-user"},
                    new int[]{R.id.note_item_left,R.id.note_item_right}
            );
            // 设置GridView的适配器为新建的simpleAdapter
            gridview.setAdapter(simpleAdapter);
        }else{
//            ArrayAdapter simpleAdapter = new ArrayAdapter(this,
//                    R.layout.notes_list_item,
//                    R.id.note_item,
//                    new String[]{"例子：减压塔","2019-01-17 15:55:47","1","2019-01-17 15:55:47","2019-01-17 15:55:47","2"}
//            );
//            // 设置GridView的适配器为新建的simpleAdapter
//            gridview.setAdapter(simpleAdapter);
            HashMap<String,String> tmp=new HashMap<>();
            tmp.put("name","减压塔");
            tmp.put("create-time","2019-01-17 15:55:47");
            tmp.put("create-user","1");

            tmp.put("update-time","2019-01-17 15:55:47");
            tmp.put("update-user","2");

            s2list.add(tmp);

                SimpleAdapter simpleAdapter=new SimpleAdapter(this,
                        s2list,
                        R.layout.notes_list_item1,
                        new String[]{"name","create-time","create-user","update-time","updaet-user"},
                        new int[]{R.id.note_item_left,R.id.note_item_right}
                );
        }

//        for (int i = 0; i < dp_data.size(); i++) {
//               String tmp=dp_data.get(i).getDparameter_name();
//               imagelist.add(tmp);
//        }
//
//        for (int i = 0; i < p_data.size(); i++) {
//            String tmp=p_data.get(i).getParameter_name();
//            imagelist.add(tmp);
//        }

        // 使用simpleAdapter封装数据，将图片显示出来
        // 参数一是当前上下文Context对象
        // 参数二是图片数据列表，要显示数据都在其中
        // 参数三是界面的XML文件，注意，不是整体界面，而是要显示在GridView中的单个Item的界面XML
        // 参数四是动态数组中与map中图片对应的项，也就是map中存储进去的相对应于图片value的key
        // 参数五是单个Item界面XML中的图片ID

//        ListView listView = (ListView) findViewById(R.id.paramter);//在视图中找到ListView
//        SimpleAdapter<HashMap<String,ImageView>> adapter = new SimpleAdapter<HashMap<String, ImageView>>(this,android.R.layout.activity_list_item,item_parameter,);//新建并配置ArrayAapeter
//        listView.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
    private  void serachonline(){
        getequipservice = new GetEquipService(this);

        getequipservice.doget(simulation,equipment, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                //Equipment equip = (Equipment) response.body();

                Log.d("lihui", "123onResponse");
                try {
                    ResponseBody httpResult = (ResponseBody )response.body();
                    //原始数据下手
                    String result = httpResult.string();
                    Log.d("lihui", result);

                    org.json.JSONObject jsonObject = new org.json.JSONObject(result);
                    //simulation_data = new EquipmentData(
                    org.json.JSONObject myjObject1=jsonObject.getJSONObject("data");//接收JSON对象里的数组
                    simulation_data.setSimulation_name(myjObject1.getString("simulation_name"));
//                    simulation_create_time=myjObject.getString("simulation_create_time");
//                    simulation_update_time=myjObject.getString("simulation_update_time");
//
//                    simulation_update_user_id=myjObject.getString("simulation_update_user_id");
//                    simulation_create_user_id=myjObject.getString("simulation_create_user_id");



                    JSONArray jsonArr_p_data= jsonObject.getJSONArray("p_data");
                    int jsonSize_school = jsonArr_p_data.length();//获取数组长度
                    for(int i = 0; i < jsonSize_school; i++ )//通过循环取出数组里的值
                    {
                        org.json.JSONObject myjObject = jsonArr_p_data.getJSONObject(i);
                        if (myjObject != null) {
                            Parameter data1 = new Parameter(myjObject);
                            Log.d("lihui", "Fragment onResponse getUniquekey---" );
                            Log.d("lihui", "Fragment onResponse data---" + data1);
                            p_data.add(data1);
                        }
                    }

                    JSONArray jsonArr_dp_data= jsonObject.getJSONArray("dp_data");
                    int jsonSize_schoold = jsonArr_p_data.length();//获取数组长度
                    for(int i = 0; i < jsonSize_schoold; i++ )//通过循环取出数组里的值
                    {
                        org.json.JSONObject myjObject = jsonArr_p_data.getJSONObject(i);
                        if (myjObject != null) {
                            Dparameter data1 = new Dparameter(myjObject);
                            Log.d("lihui", "Fragment onResponse getUniquekey---" );
                            Log.d("lihui", "Fragment onResponse data---" + data1);
                            dp_data.add(data1);
                        }
                    }

//                    if (mHandler != null) {
//                        Message msg = mHandler.obtainMessage();
//                        msg.what = 0;
//                        msg.obj = list;
//                        mHandler.sendMessage(msg);
//                        empty.setVisibility(View.GONE);
//                        cacheMap.put(type, list);
//                    }
//                    Log.d("lihui", "159 list---" + list);

                } catch (Exception e) {
                    Log.d("lihui", "114e---" + e.getMessage());
                    //pullToRefreshRecyclerView.onRefreshComplete();
                }


//                if(equip != null) {
//                    if(!equip.isError()) {
//                        PrefUtil.putEquip(ShowEquipActivity.this, PrefUtil.EQUIP_SESSION, equip);
//                        //MainActivity.start(LoginActivity.this);
//                        //LoginActivity.this.finish();
//                        //startActivity(new Intent(LoginActivity.this, Change_act.class));
//
//
//
//                        simulation_data=equip.getData();
//                        dp_data=equip.getDp_data();
//                        p_data=equip.getP_data();
//
//                        Log.i(TAG,"success");
//                        Log.i(TAG,simulation_data.getSimulation_name());
//                        Log.i(TAG,dp_data.toString());
//                    }
//                    Toast.makeText(ShowEquipActivity.this, equip.getMessage(), Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                //Toast.makeText(ShowEquipActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
                Log.d("lihui", "ERROR_-----------------------------" );

            }

        });

    }

}



