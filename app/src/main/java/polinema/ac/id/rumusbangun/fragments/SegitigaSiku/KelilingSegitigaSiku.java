package polinema.ac.id.rumusbangun.fragments.SegitigaSiku;

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
 * {@link KelilingSegitigaSiku.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class KelilingSegitigaSiku extends Fragment {

    private OnFragmentInteractionListener mListener;

    public KelilingSegitigaSiku() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keliling_segitiga_siku, container, false);
        final EditText Alas = view.findViewById(R.id.txt_kASiku);
        final EditText Lebar = view.findViewById(R.id.txt_kLSiku);
        final EditText Tinggi= view.findViewById(R.id.txt_kTSiku);
        Button calculation = view.findViewById(R.id.calculate_KelilingSiku);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String strAlas = Alas.getText().toString();
                    String strTinggi = Tinggi.getText().toString();
                    String strLebar = Lebar.getText().toString();
                    if(!TextUtils.isEmpty(strAlas) && !TextUtils.isEmpty(strLebar) && !TextUtils.isEmpty(strTinggi)){
                        float intAlas = (float) Double.parseDouble(strAlas);
                        float intLebar = (float) Double.parseDouble(strLebar);
                        float intTinggi = (float) Double.parseDouble(strTinggi);
                        rumus r = new rumus();
                        r.kelilingSegitigaSiku(intAlas, intTinggi, intLebar);
                        mListener.hitungKelilingSegitigaSiku(r.getHasil());
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
        void hitungKelilingSegitigaSiku(float hasil);
    }
}
