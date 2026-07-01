package com.discord.widgets.settings.connections;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsItemAddConnectedAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder extends MGRecyclerViewHolder<WidgetSettingsUserConnectionsAdd$Adapter, WidgetSettingsUserConnectionsAdd$PlatformItem> {
    private final WidgetSettingsItemAddConnectedAccountBinding binding;
    private final Function0<Unit> dialogDismissCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder(@LayoutRes int i, WidgetSettingsUserConnectionsAdd$Adapter widgetSettingsUserConnectionsAdd$Adapter, Function0<Unit> function0) {
        super(i, widgetSettingsUserConnectionsAdd$Adapter);
        m.checkNotNullParameter(widgetSettingsUserConnectionsAdd$Adapter, "adapter");
        m.checkNotNullParameter(function0, "dialogDismissCallback");
        this.dialogDismissCallback = function0;
        View view = this.itemView;
        int i2 = R$id.add_connected_account_image;
        ImageView imageView = (ImageView) view.findViewById(R$id.add_connected_account_image);
        if (imageView != null) {
            i2 = R$id.add_connected_account_text;
            TextView textView = (TextView) view.findViewById(R$id.add_connected_account_text);
            if (textView != null) {
                WidgetSettingsItemAddConnectedAccountBinding widgetSettingsItemAddConnectedAccountBinding = new WidgetSettingsItemAddConnectedAccountBinding((LinearLayout) view, imageView, textView);
                m.checkNotNullExpressionValue(widgetSettingsItemAddConnectedAccountBinding, "WidgetSettingsItemAddCon…untBinding.bind(itemView)");
                this.binding = widgetSettingsItemAddConnectedAccountBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public final Function0<Unit> getDialogDismissCallback() {
        return this.dialogDismissCallback;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsUserConnectionsAdd$PlatformItem widgetSettingsUserConnectionsAdd$PlatformItem) {
        onConfigure2(i, widgetSettingsUserConnectionsAdd$PlatformItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsUserConnectionsAdd$PlatformItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.addConnectedAccountText");
        textView.setText(data.getPlatform().getProperName());
        ImageView imageView = this.binding.f2622b;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Integer themedPlatformImage = data.getPlatform().getThemedPlatformImage();
        imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(view, themedPlatformImage != null ? themedPlatformImage.intValue() : 0, 0, 2, (Object) null));
        this.itemView.setOnClickListener(new WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder$onConfigure$1(this, data));
    }
}
