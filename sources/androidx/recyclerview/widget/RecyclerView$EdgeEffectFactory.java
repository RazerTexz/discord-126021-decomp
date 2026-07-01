package androidx.recyclerview.widget;

import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$EdgeEffectFactory {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;

    @NonNull
    public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i) {
        return new EdgeEffect(recyclerView.getContext());
    }
}
