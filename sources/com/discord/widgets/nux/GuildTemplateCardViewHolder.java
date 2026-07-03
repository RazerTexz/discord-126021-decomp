package com.discord.widgets.nux;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.nux.GuildTemplatesAdapter;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildTemplateViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateCardViewHolder extends RecyclerView.ViewHolder {
    private final NuxGuildTemplateCardViewHolderBinding binding;
    private final GuildTemplatesAdapter.Callbacks callbacks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateCardViewHolder(NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding, GuildTemplatesAdapter.Callbacks callbacks) {
        super(nuxGuildTemplateCardViewHolderBinding.f15197a);
        C12238m.checkNotNullParameter(nuxGuildTemplateCardViewHolderBinding, "binding");
        C12238m.checkNotNullParameter(callbacks, "callbacks");
        this.binding = nuxGuildTemplateCardViewHolderBinding;
        this.callbacks = callbacks;
    }

    public final void bind(final GuildTemplate guildTemplate) {
        C12238m.checkNotNullParameter(guildTemplate, "guildTemplate");
        TextView textView = this.binding.f15199c;
        textView.setText(guildTemplate.getTitleRes());
        DrawableCompat.setCompoundDrawablesCompat(textView, guildTemplate.getDrawableRes(), 0, C5419R.drawable.icon_carrot, 0);
        this.binding.f15198b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.GuildTemplateCardViewHolder.bind.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildTemplateCardViewHolder.this.getCallbacks().onTemplateClick(guildTemplate);
            }
        });
    }

    public final NuxGuildTemplateCardViewHolderBinding getBinding() {
        return this.binding;
    }

    public final GuildTemplatesAdapter.Callbacks getCallbacks() {
        return this.callbacks;
    }
}
