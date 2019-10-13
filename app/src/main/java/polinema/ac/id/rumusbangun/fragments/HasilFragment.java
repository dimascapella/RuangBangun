package polinema.ac.id.rumusbangun.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import polinema.ac.id.rumusbangun.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HasilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class HasilFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private String information;
    private String hasil;
    private String rumus;

    public void setInformation(String information) {
        this.information = information;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public void setRumus(String rumus) {
        this.rumus = rumus;
    }

    public HasilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hasil, container, false);
        TextView informationText = view.findViewById(R.id.title_result);
        TextView hasilText = view.findViewById(R.id.hasil_hitung);
        TextView rumusText = view.findViewById(R.id.rumus_hitung);
        informationText.setText(information);
        hasilText.setText(hasil);
        rumusText.setText(rumus);
        final Button kembali_Menu = view.findViewById(R.id.kembali_menu);
        kembali_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.kembaliMenu("menu");
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

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
        void kembaliMenu(String menu);
    }
}
