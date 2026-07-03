package p000;

import android.view.View;

/* JADX INFO: renamed from: d */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC11208d implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public static final ViewOnClickListenerC11208d f22261j = new ViewOnClickListenerC11208d(0);

    /* JADX INFO: renamed from: k */
    public static final ViewOnClickListenerC11208d f22262k = new ViewOnClickListenerC11208d(1);

    /* JADX INFO: renamed from: l */
    public static final ViewOnClickListenerC11208d f22263l = new ViewOnClickListenerC11208d(2);

    /* JADX INFO: renamed from: m */
    public static final ViewOnClickListenerC11208d f22264m = new ViewOnClickListenerC11208d(3);

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ int f22265n;

    public ViewOnClickListenerC11208d(int i) {
        this.f22265n = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f22265n;
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            throw null;
        }
    }
}
