package com.discord.widgets.guilds.join;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetGuildWelcomeChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetChannelAdapter extends RecyclerView.Adapter<WidgetGuildWelcomeSheetChannelAdapter2> {
    private List<? extends WidgetGuildWelcomeSheetChannelAdapter3> data = Collections2.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType();
    }

    public final void setData(List<? extends WidgetGuildWelcomeSheetChannelAdapter3> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(WidgetGuildWelcomeSheetChannelAdapter2 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetGuildWelcomeSheetChannelAdapter2 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            throw new IllegalArgumentException(outline.q("invalid view type: ", viewType));
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_guild_welcome_channel, parent, false);
        CardView cardView = (CardView) viewInflate;
        int i = R.id.guild_welcome_channel_description;
        TextView textView = (TextView) viewInflate.findViewById(R.id.guild_welcome_channel_description);
        if (textView != null) {
            i = R.id.guild_welcome_channel_details;
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.guild_welcome_channel_details);
            if (constraintLayout != null) {
                i = R.id.guild_welcome_channel_emoji;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.guild_welcome_channel_emoji);
                if (simpleDraweeView != null) {
                    i = R.id.guild_welcome_channel_hash;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.guild_welcome_channel_hash);
                    if (imageView != null) {
                        i = R.id.guild_welcome_channel_icon;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.guild_welcome_channel_icon);
                        if (constraintLayout2 != null) {
                            i = R.id.guild_welcome_channel_name;
                            TextView textView2 = (TextView) viewInflate.findViewById(R.id.guild_welcome_channel_name);
                            if (textView2 != null) {
                                i = R.id.guild_welcome_channel_text;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate.findViewById(R.id.guild_welcome_channel_text);
                                if (constraintLayout3 != null) {
                                    i = R.id.guild_welcome_channel_unicode_emoji;
                                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.guild_welcome_channel_unicode_emoji);
                                    if (textView3 != null) {
                                        WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding = new WidgetGuildWelcomeChannelBinding((CardView) viewInflate, cardView, textView, constraintLayout, simpleDraweeView, imageView, constraintLayout2, textView2, constraintLayout3, textView3);
                                        Intrinsics3.checkNotNullExpressionValue(widgetGuildWelcomeChannelBinding, "WidgetGuildWelcomeChanne….context), parent, false)");
                                        return new WidgetGuildWelcomeSheetChannelAdapter4(widgetGuildWelcomeChannelBinding);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
