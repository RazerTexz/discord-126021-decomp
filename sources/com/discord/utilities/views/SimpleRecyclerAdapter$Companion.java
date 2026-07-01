package com.discord.utilities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SimpleRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleRecyclerAdapter$Companion {
    private SimpleRecyclerAdapter$Companion() {
    }

    public final void addThemedDivider(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "$this$addThemedDivider");
        int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(recyclerView, 2130969022, 0, 2, (Object) null);
        Resources resources = recyclerView.getResources();
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        Drawable drawable = ResourcesCompat.getDrawable(resources, themedDrawableRes$default, context.getTheme());
        if (drawable != null) {
            m.checkNotNullExpressionValue(drawable, "ResourcesCompat.getDrawa… context.theme) ?: return");
            Context context2 = recyclerView.getContext();
            RecyclerView$LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context2, ((LinearLayoutManager) layoutManager).getOrientation());
            dividerItemDecoration.setDrawable(drawable);
            recyclerView.addItemDecoration(dividerItemDecoration);
        }
    }

    public /* synthetic */ SimpleRecyclerAdapter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
