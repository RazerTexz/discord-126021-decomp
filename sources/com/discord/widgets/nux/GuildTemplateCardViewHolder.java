package com.discord.widgets.nux;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildTemplateViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateCardViewHolder extends RecyclerView$ViewHolder {
    private final NuxGuildTemplateCardViewHolderBinding binding;
    private final GuildTemplatesAdapter$Callbacks callbacks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateCardViewHolder(NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding, GuildTemplatesAdapter$Callbacks guildTemplatesAdapter$Callbacks) {
        super(nuxGuildTemplateCardViewHolderBinding.a);
        m.checkNotNullParameter(nuxGuildTemplateCardViewHolderBinding, "binding");
        m.checkNotNullParameter(guildTemplatesAdapter$Callbacks, "callbacks");
        this.binding = nuxGuildTemplateCardViewHolderBinding;
        this.callbacks = guildTemplatesAdapter$Callbacks;
    }

    public final void bind(GuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        TextView textView = this.binding.c;
        textView.setText(guildTemplate.getTitleRes());
        DrawableCompat.setCompoundDrawablesCompat(textView, guildTemplate.getDrawableRes(), 0, 2131232268, 0);
        this.binding.f2132b.setOnClickListener(new GuildTemplateCardViewHolder$bind$2(this, guildTemplate));
    }

    public final NuxGuildTemplateCardViewHolderBinding getBinding() {
        return this.binding;
    }

    public final GuildTemplatesAdapter$Callbacks getCallbacks() {
        return this.callbacks;
    }
}
