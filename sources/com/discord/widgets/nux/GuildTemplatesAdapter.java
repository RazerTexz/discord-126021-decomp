package com.discord.widgets.nux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.databinding.NuxGuildTemplateTextViewHolderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.nux.GuildTemplatesAdapter2;
import com.google.android.material.card.MaterialCardView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplatesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Callbacks callbacks;
    private List<? extends GuildTemplatesAdapter2> items;

    /* JADX INFO: compiled from: GuildTemplatesAdapter.kt */
    public interface Callbacks {
        void onTemplateClick(GuildTemplates guildTemplate);
    }

    public GuildTemplatesAdapter(Callbacks callbacks) {
        Intrinsics3.checkNotNullParameter(callbacks, "callbacks");
        this.callbacks = callbacks;
        this.items = Collections2.emptyList();
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

    public final List<GuildTemplatesAdapter2> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        GuildTemplatesAdapter2 guildTemplatesAdapter2 = this.items.get(position);
        if (guildTemplatesAdapter2 instanceof GuildTemplatesAdapter2.Template) {
            if (!(holder instanceof GuildTemplateViewHolders)) {
                holder = null;
            }
            GuildTemplateViewHolders guildTemplateViewHolders = (GuildTemplateViewHolders) holder;
            if (guildTemplateViewHolders != null) {
                guildTemplateViewHolders.bind(((GuildTemplatesAdapter2.Template) guildTemplatesAdapter2).getGuildTemplate());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        GuildTemplatesAdapter2.Companion companion = GuildTemplatesAdapter2.INSTANCE;
        if (viewType == companion.getTEXT()) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.nux_guild_template_text_view_holder, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            NuxGuildTemplateTextViewHolderBinding nuxGuildTemplateTextViewHolderBinding = new NuxGuildTemplateTextViewHolderBinding((TextView) viewInflate);
            Intrinsics3.checkNotNullExpressionValue(nuxGuildTemplateTextViewHolderBinding, "NuxGuildTemplateTextView…          false\n        )");
            return new GuildTemplateViewHolders2(nuxGuildTemplateTextViewHolderBinding);
        }
        if (viewType != companion.getTEMPLATE()) {
            throw new IllegalStateException(outline.q("Missing view type for ", viewType));
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.nux_guild_template_card_view_holder, parent, false);
        MaterialCardView materialCardView = (MaterialCardView) viewInflate2;
        TextView textView = (TextView) viewInflate2.findViewById(R.id.nux_guild_template_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R.id.nux_guild_template_text)));
        }
        NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding = new NuxGuildTemplateCardViewHolderBinding((MaterialCardView) viewInflate2, materialCardView, textView);
        Intrinsics3.checkNotNullExpressionValue(nuxGuildTemplateCardViewHolderBinding, "NuxGuildTemplateCardView…          false\n        )");
        return new GuildTemplateViewHolders(nuxGuildTemplateCardViewHolderBinding, this.callbacks);
    }

    public final void setItems(List<? extends GuildTemplatesAdapter2> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.items = _Collections.plus((Collection) Collections2.listOf((Object[]) new GuildTemplatesAdapter2[]{new GuildTemplatesAdapter2.Template(GuildTemplates.CreateMyOwn), GuildTemplatesAdapter2.Text.INSTANCE}), (Iterable) list);
        notifyDataSetChanged();
    }
}
