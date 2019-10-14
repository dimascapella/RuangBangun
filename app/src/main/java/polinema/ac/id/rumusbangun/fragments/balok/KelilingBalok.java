package polinema.ac.id.rumusbangun.fragments.balok;

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
 * {@link KelilingBalok.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class KelilingBalok extends Fragment {

    private OnFragmentInteractionListener mListener;

    public KelilingBalok() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keliling_balok, container, false);
        final EditText klPanjangBalok = view.findViewById(R.id.txt_klPanBalok);
        final EditText klLebarBalok = view.findViewById(R.id.txt_klleBalok);
        final EditText klTinggiBalok = view.findViewById(R.id.txt_kltiBalok);
        Button calculation = view.findViewById(R.id.calculate_klBalok);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String strklPanjang = klPanjangBalok.getText().toString();
                    String strklTinggi = klTinggiBalok.getText().toString();
                    String strklLebar = klLebarBalok.getText().toString();
                    if(!TextUtils.isEmpty(strklPanjang) && !TextUtils.isEmpty(strklLebar) && !TextUtils.isEmpty(strklTinggi)){
                        int intklPanjang = Integer.parseInt(strklPanjang);
                        int intklTinggi = Integer.parseInt(strklTinggi);
                        int intklLebar = Integer.parseInt(strklLebar);
                        rumus r = new rumus();
                        r.kelilingBalok(intklPanjang, intklLebar, intklTinggi);
                        mListener.hitungKelilingBalok(r.getHasil());
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
        void hitungKelilingBalok(float hasil);
    }
}