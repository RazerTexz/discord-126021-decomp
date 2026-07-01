package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.discord.R$a;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.GridColumnSpaceItemDecoration;
import d0.z.d.m;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GifLoadingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifLoadingView extends RecyclerView {
    private boolean isStaggered;
    private final GifLoadingView$LoadingGifAdapter loadingGifAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new GifLoadingView$LoadingGifAdapter();
    }

    private final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$a.GifLoadingView, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.GifLoadingView, 0, 0)");
        try {
            this.isStaggered = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            setAdapter(this.loadingGifAdapter);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static /* synthetic */ void updateView$default(GifLoadingView gifLoadingView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 4;
        }
        gifLoadingView.updateView(i, i2);
    }

    public final void updateView(int numColumns, int numRows) {
        int i = 1;
        setLayoutManager(new StaggeredGridLayoutManager(numColumns, 1));
        addItemDecoration(new GridColumnSpaceItemDecoration(DimenUtils.dpToPixels(8), numColumns));
        int i2 = numRows * numColumns;
        ArrayList arrayList = new ArrayList();
        if (this.isStaggered) {
            arrayList.add(96);
            int i3 = i2 - 1;
            while (i < i3) {
                arrayList.add(Integer.valueOf((i % 2 != 0 || i >= numColumns) ? Opcodes.IF_ICMPNE : 96));
                i++;
            }
            arrayList.add(96);
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList.add(96);
            }
        }
        this.loadingGifAdapter.setData(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new GifLoadingView$LoadingGifAdapter();
        initialize(attributeSet);
    }

    public /* synthetic */ GifLoadingView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new GifLoadingView$LoadingGifAdapter();
        initialize(attributeSet);
    }

    public /* synthetic */ GifLoadingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
