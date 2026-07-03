package com.discord.widgets.guilds.join;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildWelcomeChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetChannelAdapter extends RecyclerView.Adapter<BaseChannelViewHolder> {
    private List<? extends ChannelItem> data = C12147n.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType();
    }

    public final void setData(List<? extends ChannelItem> data) {
        C12238m.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseChannelViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            throw new IllegalArgumentException(C1643a.m871q("invalid view type: ", viewType));
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_guild_welcome_channel, parent, false);
        CardView cardView = (CardView) viewInflate;
        int i = C5419R.id.guild_welcome_channel_description;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.guild_welcome_channel_description);
        if (textView != null) {
            i = C5419R.id.guild_welcome_channel_details;
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(C5419R.id.guild_welcome_channel_details);
            if (constraintLayout != null) {
                i = C5419R.id.guild_welcome_channel_emoji;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.guild_welcome_channel_emoji);
                if (simpleDraweeView != null) {
                    i = C5419R.id.guild_welcome_channel_hash;
                    ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.guild_welcome_channel_hash);
                    if (imageView != null) {
                        i = C5419R.id.guild_welcome_channel_icon;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(C5419R.id.guild_welcome_channel_icon);
                        if (constraintLayout2 != null) {
                            i = C5419R.id.guild_welcome_channel_name;
                            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.guild_welcome_channel_name);
                            if (textView2 != null) {
                                i = C5419R.id.guild_welcome_channel_text;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate.findViewById(C5419R.id.guild_welcome_channel_text);
                                if (constraintLayout3 != null) {
                                    i = C5419R.id.guild_welcome_channel_unicode_emoji;
                                    TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.guild_welcome_channel_unicode_emoji);
                                    if (textView3 != null) {
                                        WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding = new WidgetGuildWelcomeChannelBinding((CardView) viewInflate, cardView, textView, constraintLayout, simpleDraweeView, imageView, constraintLayout2, textView2, constraintLayout3, textView3);
                                        C12238m.checkNotNullExpressionValue(widgetGuildWelcomeChannelBinding, "WidgetGuildWelcomeChanne….context), parent, false)");
                                        return new ChannelViewHolder(widgetGuildWelcomeChannelBinding);
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
