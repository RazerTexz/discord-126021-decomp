package com.discord.widgets.nux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.databinding.NuxGuildTemplateTextViewHolderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.nux.GuildTemplateViewType;
import com.google.android.material.card.MaterialCardView;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplatesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Callbacks callbacks;
    private List<? extends GuildTemplateViewType> items;

    /* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
    public interface Callbacks {
        void onTemplateClick(GuildTemplate guildTemplate);
    }

    public GuildTemplatesAdapter(Callbacks callbacks) {
        C12238m.checkNotNullParameter(callbacks, "callbacks");
        this.callbacks = callbacks;
        this.items = C12147n.emptyList();
    }

    public final Callbacks getCallbacks() {
        return this.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getViewType();
    }

    public final List<GuildTemplateViewType> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        GuildTemplateViewType guildTemplateViewType = this.items.get(position);
        if (guildTemplateViewType instanceof GuildTemplateViewType.Template) {
            if (!(holder instanceof GuildTemplateCardViewHolder)) {
                holder = null;
            }
            GuildTemplateCardViewHolder guildTemplateCardViewHolder = (GuildTemplateCardViewHolder) holder;
            if (guildTemplateCardViewHolder != null) {
                guildTemplateCardViewHolder.bind(((GuildTemplateViewType.Template) guildTemplateViewType).getGuildTemplate());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        GuildTemplateViewType.Companion companion = GuildTemplateViewType.INSTANCE;
        if (viewType == companion.getTEXT()) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.nux_guild_template_text_view_holder, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            NuxGuildTemplateTextViewHolderBinding nuxGuildTemplateTextViewHolderBinding = new NuxGuildTemplateTextViewHolderBinding((TextView) viewInflate);
            C12238m.checkNotNullExpressionValue(nuxGuildTemplateTextViewHolderBinding, "NuxGuildTemplateTextView…          false\n        )");
            return new GuildTemplateTextViewHolder(nuxGuildTemplateTextViewHolderBinding);
        }
        if (viewType != companion.getTEMPLATE()) {
            throw new IllegalStateException(C1643a.m871q("Missing view type for ", viewType));
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.nux_guild_template_card_view_holder, parent, false);
        MaterialCardView materialCardView = (MaterialCardView) viewInflate2;
        TextView textView = (TextView) viewInflate2.findViewById(C5419R.id.nux_guild_template_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(C5419R.id.nux_guild_template_text)));
        }
        NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding = new NuxGuildTemplateCardViewHolderBinding((MaterialCardView) viewInflate2, materialCardView, textView);
        C12238m.checkNotNullExpressionValue(nuxGuildTemplateCardViewHolderBinding, "NuxGuildTemplateCardView…          false\n        )");
        return new GuildTemplateCardViewHolder(nuxGuildTemplateCardViewHolderBinding, this.callbacks);
    }

    public final void setItems(List<? extends GuildTemplateViewType> list) {
        C12238m.checkNotNullParameter(list, "value");
        this.items = C12163u.plus((Collection) C12147n.listOf((Object[]) new GuildTemplateViewType[]{new GuildTemplateViewType.Template(GuildTemplate.CreateMyOwn), GuildTemplateViewType.Text.INSTANCE}), (Iterable) list);
        notifyDataSetChanged();
    }
}
