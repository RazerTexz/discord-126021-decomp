package androidx.fragment.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost$TabContentFactory;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTabHost$DummyTabFactory implements TabHost$TabContentFactory {
    private final Context mContext;

    public FragmentTabHost$DummyTabFactory(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.TabHost$TabContentFactory
    public View createTabContent(String str) {
        View view = new View(this.mContext);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }
}
