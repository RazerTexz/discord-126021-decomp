package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;

/* JADX INFO: loaded from: classes.dex */
public class NavItemSelectedListener implements AdapterView$OnItemSelectedListener {
    private final ActionBar$OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar$OnNavigationListener actionBar$OnNavigationListener) {
        this.mListener = actionBar$OnNavigationListener;
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ActionBar$OnNavigationListener actionBar$OnNavigationListener = this.mListener;
        if (actionBar$OnNavigationListener != null) {
            actionBar$OnNavigationListener.onNavigationItemSelected(i, j);
        }
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
