package polinema.ac.id.rumusbangun.fragments.Limas;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.utils.rumus;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VolumeLimas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class VolumeLimas extends Fragment {

    private OnFragmentInteractionListener mListener;

    public VolumeLimas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volume_limas, container, false);
        final EditText luasAlas = view.findViewById(R.id.txt_vlaLimas);
        final EditText tinggi = view.findViewById(R.id.txt_vTLimas);
        Button calculation = view.findViewById(R.id.calculate_vLimas);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String strLuasAlas= luasAlas.getText().toString();
                    String strTinggi= tinggi.getText().toString();
                    if(!TextUtils.isEmpty(strLuasAlas) && !TextUtils.isEmpty(strTinggi)){
                        int intLuasAlas = Integer.parseInt(strLuasAlas);
                        int intTinggi = Integer.parseInt(strTinggi);
                        rumus r = new rumus();
                        r.vLimas(intLuasAlas, intTinggi);
                        mListener.hitungVolumeLimas(r.getHasil());
                    }else{
                        Toast.makeText(getActivity(), "Invalid Request!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void hitungVolumeLimas(float hasil);
    }
}
