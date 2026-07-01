package b.o.a.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.HashMap;

/* JADX INFO: compiled from: MarkerLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends FrameLayout {

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, View> j;

    public c(@NonNull Context context) {
        super(context);
        this.j = new HashMap<>();
    }
}
