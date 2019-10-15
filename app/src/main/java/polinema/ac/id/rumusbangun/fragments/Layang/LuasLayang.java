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
 * {@link LuasLayang.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class LuasLayang extends Fragment {

    private OnFragmentInteractionListener mListener;

    public LuasLayang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_luas_layang, container, false);
        final EditText d1 = view.findViewById(R.id.txt_d1Layang);
        final EditText d2 = view.findViewById(R.id.txt_d2Layang);
        Button calculation = view.findViewById(R.id.calculate_LuasLayang);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String strd1= d1.getText().toString();
                    String strd2= d2.getText().toString();
                    if(!TextUtils.isEmpty(strd1) && !TextUtils.isEmpty(strd2)){
                        float intd1 = (float) Double.parseDouble(strd1);
                        float intd2 = (float) Double.parseDouble(strd2);
                        rumus r = new rumus();
                        r.luasLayang(intd1, intd2);
                        mListener.hitungLuasLayang(r.getHasil());
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
        void hitungLuasLayang(float hasil);
    }
}
