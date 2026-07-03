package com.discord.widgets.user.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserProfileAdapterItemEmptyBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserProfileEmptyListItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserProfileEmptyListItem<T extends MGRecyclerAdapter<D>, D> extends MGRecyclerViewHolder<T, D> {
    private final WidgetUserProfileAdapterItemEmptyBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserProfileEmptyListItem(@LayoutRes int i, T t, @AttrRes int i2, @StringRes int i3) {
        super(i, t);
        C12238m.checkNotNullParameter(t, "adapter");
        View view = this.itemView;
        int i4 = C5419R.id.user_profile_adapter_item_empty;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.user_profile_adapter_item_empty);
        if (imageView != null) {
            i4 = C5419R.id.user_profile_adapter_item_empty_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_empty_text);
            if (textView != null) {
                WidgetUserProfileAdapterItemEmptyBinding widgetUserProfileAdapterItemEmptyBinding = new WidgetUserProfileAdapterItemEmptyBinding((LinearLayout) view, imageView, textView);
                C12238m.checkNotNullExpressionValue(widgetUserProfileAdapterItemEmptyBinding, "WidgetUserProfileAdapter…ptyBinding.bind(itemView)");
                this.binding = widgetUserProfileAdapterItemEmptyBinding;
                View view2 = this.itemView;
                C12238m.checkNotNullExpressionValue(view2, "itemView");
                imageView.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(view2, i2, 0, 2, (Object) null));
                textView.setText(i3);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }
}
