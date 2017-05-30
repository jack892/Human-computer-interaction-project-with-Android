package ium.swag.yolo.saxs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GestureFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GestureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GestureFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static String PACKAGE_NAME;
    private AnimationDrawable animation;

    public GestureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GestureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GestureFragment newInstance(String param1, String param2) {
        GestureFragment fragment = new GestureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        PACKAGE_NAME = getContext().getPackageName();
        animation = new AnimationDrawable();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gesture, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        createAnimation(mParam1);

        Button playButton = (Button) getView().findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.stop();
                animation.start();
                //createAnimation(mParam1);
            }
        });

        Button stopButton = (Button) getView().findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.stop();
                //createAnimation(mParam1);
            }
        });

        Button textButton = (Button) getActivity().findViewById(R.id.buttonToText);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                TextFragment fragment2 = new TextFragment().newInstance(mParam1,mParam1);
                fragmentTransaction2.addToBackStack("xyz");
                fragmentTransaction2.hide(GestureFragment.this);
                fragmentTransaction2.add(android.R.id.content, fragment2);
                fragmentTransaction2.commit();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void createAnimation(String carattere){
        animation.stop();
        for ( int i = 0; i< carattere.length() ; i++ ){
            switch (carattere.charAt(i)) {
                case 'a':
                    animation.addFrame(getResources().getDrawable(R.drawable.a),500);
                    break;
                case 'b':
                    animation.addFrame(getResources().getDrawable(R.drawable.b),500);
                    break;
                case 'c':
                    animation.addFrame(getResources().getDrawable(R.drawable.c),500);
                    break;
                case 'd':
                    animation.addFrame(getResources().getDrawable(R.drawable.d),500);
                    break;
                case 'e':
                    animation.addFrame(getResources().getDrawable(R.drawable.e),500);
                    break;
                case 'f':
                    animation.addFrame(getResources().getDrawable(R.drawable.f),500);
                    break;
                case 'g':
                    animation.addFrame(getResources().getDrawable(R.drawable.g),500);
                    break;
                case 'h':
                    animation.addFrame(getResources().getDrawable(R.drawable.h),500);
                    break;
                case 'i':
                    animation.addFrame(getResources().getDrawable(R.drawable.i),500);
                    break;
                case 'j':
                    animation.addFrame(getResources().getDrawable(R.drawable.j),500);
                    break;
                case 'k':
                    animation.addFrame(getResources().getDrawable(R.drawable.k),500);
                    break;
                case 'l':
                    animation.addFrame(getResources().getDrawable(R.drawable.l),500);
                    break;
                case 'm':
                    animation.addFrame(getResources().getDrawable(R.drawable.m),500);
                    break;
                case 'n':
                    animation.addFrame(getResources().getDrawable(R.drawable.n),500);
                    break;
                case 'o':
                    animation.addFrame(getResources().getDrawable(R.drawable.o),500);
                    break;
                case 'p':
                    animation.addFrame(getResources().getDrawable(R.drawable.p),500);
                    break;
                case 'q':
                    animation.addFrame(getResources().getDrawable(R.drawable.q),500);
                    break;
                case 'r':
                    animation.addFrame(getResources().getDrawable(R.drawable.r),500);
                    break;
                case 's':
                    animation.addFrame(getResources().getDrawable(R.drawable.s),500);
                    break;
                case 't':
                    animation.addFrame(getResources().getDrawable(R.drawable.t),500);
                    break;
                case 'u':
                    animation.addFrame(getResources().getDrawable(R.drawable.u),500);
                    break;
                case 'v':
                    animation.addFrame(getResources().getDrawable(R.drawable.v),500);
                    break;
                case 'w':
                    animation.addFrame(getResources().getDrawable(R.drawable.w),500);
                    break;
                case 'x':
                    animation.addFrame(getResources().getDrawable(R.drawable.x),500);
                    break;
                case 'y':
                    animation.addFrame(getResources().getDrawable(R.drawable.y),500);
                    break;
                case 'z':
                    animation.addFrame(getResources().getDrawable(R.drawable.z),500);
                    break;
                default:
                    animation.addFrame(getResources().getDrawable(R.drawable.spazio),500);
                    break;

            }
        }
        animation.setOneShot(true);


        ImageView imageView = (ImageView) getView().findViewById(R.id.gestureImageView);
        imageView.setImageDrawable(animation);

        // start the animation!
        animation.start();
    }
}
