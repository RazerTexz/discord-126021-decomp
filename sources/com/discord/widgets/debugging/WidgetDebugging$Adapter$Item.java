package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.app.AppLog$LoggedItem;
import com.discord.databinding.WidgetDebuggingAdapterItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$Adapter$Item extends MGRecyclerViewHolder<WidgetDebugging$Adapter, AppLog$LoggedItem> {
    private final WidgetDebuggingAdapterItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDebugging$Adapter$Item(@LayoutRes int i, WidgetDebugging$Adapter widgetDebugging$Adapter) {
        super(i, widgetDebugging$Adapter);
        m.checkNotNullParameter(widgetDebugging$Adapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.log_message);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.log_message)));
        }
        WidgetDebuggingAdapterItemBinding widgetDebuggingAdapterItemBinding = new WidgetDebuggingAdapterItemBinding((LinearLayout) view, textView);
        m.checkNotNullExpressionValue(widgetDebuggingAdapterItemBinding, "WidgetDebuggingAdapterItemBinding.bind(itemView)");
        this.binding = widgetDebuggingAdapterItemBinding;
    }

    public static final /* synthetic */ WidgetDebuggingAdapterItemBinding access$getBinding$p(WidgetDebugging$Adapter$Item widgetDebugging$Adapter$Item) {
        return widgetDebugging$Adapter$Item.binding;
    }

    @ColorInt
    private final int getColor(Context context, int priority) {
        if (priority == 2) {
            return ColorCompat.getThemedColor(context, 2130969978);
        }
        if (priority == 3) {
            return ColorCompat.getColor(context, 2131100304);
        }
        if (priority != 5) {
            return priority != 6 ? ColorCompat.getThemedColor(context, 2130969971) : ColorCompat.getColor(context, 2131100382);
        }
        return ColorCompat.getColor(context, 2131100410);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, AppLog$LoggedItem appLog$LoggedItem) {
        onConfigure2(i, appLog$LoggedItem);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0046  */
    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, AppLog$LoggedItem data) {
        String string;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2361b;
        textView.setTextColor(getColor(a.I(textView, "binding.logMessage", "binding.logMessage.context"), data.priority));
        TextView textView2 = this.binding.f2361b;
        m.checkNotNullExpressionValue(textView2, "binding.logMessage");
        StringBuilder sb = new StringBuilder();
        sb.append(data.message);
        Throwable th = data.throwable;
        if (th != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('\n');
            sb2.append(th);
            string = sb2.toString();
            if (string == null) {
                string = "";
            }
        } else {
            string = "";
        }
        sb.append(string);
        textView2.setText(sb.toString());
        TextView textView3 = this.binding.f2361b;
        m.checkNotNullExpressionValue(textView3, "binding.logMessage");
        textView3.setMaxLines(2);
        LinearLayout linearLayout = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(linearLayout, new WidgetDebugging$Adapter$Item$onConfigure$2(this));
        this.itemView.setOnClickListener(new WidgetDebugging$Adapter$Item$onConfigure$3(this));
    }
}
