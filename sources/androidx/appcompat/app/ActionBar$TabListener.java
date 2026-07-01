package androidx.appcompat.app;

import androidx.fragment.app.FragmentTransaction;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ActionBar$TabListener {
    void onTabReselected(ActionBar$Tab actionBar$Tab, FragmentTransaction fragmentTransaction);

    void onTabSelected(ActionBar$Tab actionBar$Tab, FragmentTransaction fragmentTransaction);

    void onTabUnselected(ActionBar$Tab actionBar$Tab, FragmentTransaction fragmentTransaction);
}
