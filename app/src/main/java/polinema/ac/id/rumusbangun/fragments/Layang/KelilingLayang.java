package polinema.ac.id.rumusbangun.fragments.Layang;

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
 * {@link KelilingLayang.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class KelilingLayang extends Fragment {

    private OnFragmentInteractionListener mListener;

    public KelilingLayang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keliling_layang, container, false);
        final EditText sisi1 = view.findViewById(R.id.txt_Ks1Layang);
        final EditText sisi2 = view.findViewById(R.id.txt_Ks2Layang);
        final EditText sisi3 = view.findViewById(R.id.txt_Ks3Layang);
        final EditText sisi4 = view.findViewById(R.id.txt_Ks4Layang);
        Button calculation = view.findViewById(R.id.calculate_KelilingLayang);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String strSisi1 = sisi1.getText().toString();
                    String strSisi2 = sisi2.getText().toString();
                    String strSisi3 = sisi3.getText().toString();
                    String strSisi4 = sisi4.getText().toString();
                    if(!TextUtils.isEmpty(strSisi4) && !TextUtils.isEmpty(strSisi1) && !TextUtils.isEmpty(strSisi2) && !TextUtils.isEmpty(strSisi3)){
                        float intS1 = (float) Double.parseDouble(strSisi1);
                        float intS2 = (float) Double.parseDouble(strSisi2);
                        float intS3 = (float) Double.parseDouble(strSisi3);
                        float intS4 = (float) Double.parseDouble(strSisi4);
                        rumus r = new rumus();
                        r.kelilingLayang(intS1, intS2, intS3, intS4);
                        mListener.hitungKelilingLayang(r.getHasil());
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
        void hitungKelilingLayang(float hasil);
    }
}
