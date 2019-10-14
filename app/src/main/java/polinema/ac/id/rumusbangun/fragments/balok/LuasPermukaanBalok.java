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
 * {@link LuasPermukaanBalok.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class LuasPermukaanBalok extends Fragment {

    private OnFragmentInteractionListener mListener;

    public LuasPermukaanBalok() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_luas_permukaan_balok, container, false);
        final EditText lpPanjangBalok = view.findViewById(R.id.txt_lpPanBalok);
        final EditText lpLebarBalok = view.findViewById(R.id.txt_lpleBalok);
        final EditText lpTinggiBalok = view.findViewById(R.id.txt_lptiBalok);
        Button calculation = view.findViewById(R.id.calculate_lpBalok);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String strlpPanjang = lpPanjangBalok.getText().toString();
                    String strlpTinggi = lpTinggiBalok.getText().toString();
                    String strlpLebar = lpLebarBalok.getText().toString();
                    if(!TextUtils.isEmpty(strlpPanjang) && !TextUtils.isEmpty(strlpLebar) && !TextUtils.isEmpty(strlpTinggi)){
                        float intlpPanjang = (float) Double.parseDouble(strlpPanjang);
                        float intlpTinggi = (float) Double.parseDouble(strlpTinggi);
                        float intlpLebar = (float) Double.parseDouble(strlpLebar);
                        rumus r = new rumus();
                        r.lpBalok(intlpPanjang, intlpLebar, intlpTinggi);
                        mListener.hitungLuasPermukaanBalok(r.getHasil());
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
        void hitungLuasPermukaanBalok(float hasil);
    }
}
