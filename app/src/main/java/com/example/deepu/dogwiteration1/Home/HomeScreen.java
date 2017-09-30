package com.example.deepu.dogwiteration1.Home;


import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.deepu.dogwiteration1.BreedActivity.BreedBlak;
import com.example.deepu.dogwiteration1.BreedActivity.breed_details;
import com.example.deepu.dogwiteration1.PlantRelevant.PlantFirstPage;
import com.example.deepu.dogwiteration1.R;
import com.example.deepu.dogwiteration1.drawerFragment.CalendarReminder;
import com.example.deepu.dogwiteration1.drawerFragment.DogPark;
import com.example.deepu.dogwiteration1.drawerFragment.Plant;
import com.example.deepu.dogwiteration1.drawerFragment.UnityPlayerNativeFragment;
import com.example.deepu.dogwiteration1.drawerFragment.Vet;
import com.example.deepu.dogwiteration1.drawerFragment.VetCare;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeScreen extends Fragment {
//    ViewPager viewPager;
//    String arrayName[] = {"body Language","Toxic Plants","Map","Breed Details","Vacination Reminder"};
   private UnityPlayerNativeFragment upnf1;
    private Plant plantFrag;
    private HomeScreen homeScreenFrag;
    private Vet vetFrag;
    private CalendarReminder hometreatFrag;
    private DogPark DogParkFrag;
    private VetCare vetCareFrag;
    private breed_details breed_detailsFrag;
    private PlantFirstPage pfpFrag;
    private BreedBlak brrBlank;
//    CustomSwipeAdaptor customSwipeAdaptor;
//    LinearLayout slideDotsPanel;
//    private int dotsCount;
//    private ImageView[] dots;
    ImageView captureImg;
    ImageButton captureBtn;
    Integer REQUEST_CAMERA = 1,SELECT_FILE=0;
    Button bodyLang,plantFind,breedDet,mapsBtn;


    public HomeScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View v =  inflater.inflate(R.layout.fragment_home_screen, container, false);
        captureBtn = (ImageButton) v.findViewById(R.id.img_cap);
        captureImg = (ImageView) v.findViewById(R.id.cust_img);
        bodyLang = (Button) v.findViewById(R.id.bodyH_Lang);
        plantFind = (Button) v.findViewById(R.id.plantH_find);
        breedDet = (Button) v.findViewById(R.id.breedH_detail);
        mapsBtn = (Button) v.findViewById(R.id.mapH_find);

        bodyLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upnf1 = new UnityPlayerNativeFragment();
                            FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                            ft1.hide(getFragmentManager().findFragmentById(R.id.content_main));
                            ft1.add(R.id.blank_hsscreen,upnf1);
                            ft1.addToBackStack(null);
                            ft1.commit();

            }
        });

        plantFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pfpFrag = new PlantFirstPage();
                FragmentTransaction ft2  = getFragmentManager().beginTransaction();
                ft2.add(R.id.blank_hsscreen,pfpFrag);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });

        breedDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brrBlank = new BreedBlak();
                FragmentTransaction ft3 = getFragmentManager().beginTransaction();
                ft3.add(R.id.hh_screen,brrBlank);
                ft3.addToBackStack(null);
                ft3.commit();

            }
        });

        mapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vetCareFrag = new VetCare();
                FragmentTransaction ft4 = getFragmentManager().beginTransaction();
                ft4.add(R.id.blank_hsscreen,vetCareFrag);
                ft4.addToBackStack(null);
                ft4.commit();

            }
        });

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectImage();
//                Intent camera_intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                File file = getFile();
//                camera_intent1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
//                startActivityForResult(camera_intent1,CAM_REQUEST);


            }
        });



//        viewPager = (ViewPager) v.findViewById(R.id.vviewPager);
//        slideDotsPanel = (LinearLayout) v.findViewById(R.id.slider_dots);
//        customSwipeAdaptor = new CustomSwipeAdaptor(getActivity());
//        viewPager.setAdapter(customSwipeAdaptor);
//        dotsCount = customSwipeAdaptor.getCount();
//        dots = new ImageView[dotsCount];
//
//        for(int i = 0; i<dotsCount;i++){
//            dots[i] =new ImageView(getActivity());
//            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot));
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//
//            params.setMargins(8,0,8,0);
//            slideDotsPanel.addView(dots[i],params);
//        }
//
//        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                for(int i = 0; i<dotsCount;i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot));
//
//                }
//                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
////        CircleMenu circleMenu = (CircleMenu) v.findViewById(R.id.circle_menu);
////        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.add,R.drawable.remove)
////                .addSubMenu(Color.parseColor("#258CFF"),R.drawable.doggy_menu_icon)
////                .addSubMenu(Color.parseColor("#6c4c41"),R.drawable.plantinhouse_menu_icon)
////                .addSubMenu(Color.parseColor("#ff0000"),R.drawable.firstaid_menu_icon)
////                .addSubMenu(Color.parseColor("#03a9f4"),R.drawable.breed_icon)
////                .addSubMenu(Color.parseColor("#9fefff"),R.drawable.dogcare)
////                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
////                    @Override
////                    public void onMenuSelected(int index) {
////                        Toast.makeText(getActivity(),"You selected" +arrayName[index ],Toast.LENGTH_SHORT).show();
////                        if(index == 0){
////                            upnf1 = new UnityPlayerNativeFragment();
////                            FragmentTransaction ft1 = getFragmentManager().beginTransaction();
////                            ft1.hide(getFragmentManager().findFragmentById(R.id.content_main));
////                            ft1.add(R.id.content_main,upnf1);
////                            ft1.addToBackStack(null);
////                            ft1.commit();
////                        }else
////                            if(index == 1){
////                                pfpFrag = new PlantFirstPage();
////                                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
////                                ft2.hide(getFragmentManager().findFragmentById(R.id.content_main));
////                                ft2.add(R.id.content_main,pfpFrag);
////                                ft2.addToBackStack(null);
////                                ft2.commit();
////                            }else
////                                if(index == 2)
////                                {
////                                    DogParkFrag = new DogPark();
////                                    FragmentTransaction ft3 = getFragmentManager().beginTransaction();
////                                    ft3.hide(getFragmentManager().findFragmentById(R.id.content_main));
////                                    ft3.add(R.id.content_main,DogParkFrag);
////                                    ft3.addToBackStack(null);
////                                    ft3.commit();
////                                }
////                                else if(index == 3){
////                                    breed_detailsFrag = new breed_details();
////                                    FragmentTransaction ft4 = getFragmentManager().beginTransaction();
////                                    ft4.hide(getFragmentManager().findFragmentById(R.id.content_main));
////                                    ft4.add(R.id.content_main,breed_detailsFrag);
////                                    ft4.addToBackStack(null);
////                                    ft4.commit();
////
////                                }
////
////                    }
////                });
//
//
//
////
////
////                viewPager = (ViewPager) v.findViewById(R.id.viewPager);
////
////        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getActivity());
////
////        viewPager.setAdapter(viewPageAdapter);
        return v;

    }

    private File getFile(){

       // File folder  = new File("sdcard/Upet");
        File folder  = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        if(!folder.exists()){
            folder.mkdir();
        }

        File image_file = new File(folder,"cam_image.jpeg");
        return image_file;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
        }else {
            getActivity().setTitle("Home");
            getActivity().invalidateOptionsMenu();

        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        String path = "sdcard/Upet/cam_image.jpeg";
//        captureImg.setImageDrawable(Drawable.createFromPath(path));
       // super.onActivityResult(requestCode,resultCode,data);

        if (resultCode== Activity.RESULT_OK){

            if(resultCode== REQUEST_CAMERA){
                Bundle bundle = data.getExtras();
                final Bitmap bitmap = (Bitmap) bundle.get("data");
                captureImg.setImageBitmap(bitmap);


            }else if(requestCode == SELECT_FILE){

                Uri selectedImageUri = data.getData();
                captureImg.setImageURI(selectedImageUri);

            }
        }

    }
    public void SelectImage(){

        final CharSequence[] items = {"Camera","Gallery","Cancel"};

        AlertDialog.Builder builder1 = new  AlertDialog.Builder(getActivity());
        builder1.setTitle("Customize HomePage");
        builder1.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(items[i].equals("Camera")){

                    String[] permissos = {"android.permission.CAMERA"};

                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(getActivity(),
                                permissos,
                                REQUEST_CAMERA
                        );
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,REQUEST_CAMERA);

                    }else{

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,REQUEST_CAMERA);}

                }else if (items[i].equals("Gallery")){
                    Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent,"Select File"),SELECT_FILE);


                }else if(items[i].equals("Cancel")){
                    dialogInterface.dismiss();

                }
            }
        });
        builder1.show();


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_plant_fragment, menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().invalidateOptionsMenu();
        getActivity().setTitle("Home");

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_search);
        item.setVisible(false);
    }

}
