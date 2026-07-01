package com.discord.widgets.chat.input.applicationcommands;

import android.graphics.PorterDuff$Mode;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewAppcommandsOptiontitleListitemBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedAppCommandTitleAdapterItem extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandItem> {
    private final ViewAppcommandsOptiontitleListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedAppCommandTitleAdapterItem(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(R$layout.view_appcommands_optiontitle_listitem, selectedApplicationCommandAdapter);
        m.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.appcommands_optiontitle;
        TextView textView = (TextView) view.findViewById(R$id.appcommands_optiontitle);
        if (textView != null) {
            i = R$id.appcommands_optiontitle_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.appcommands_optiontitle_avatar);
            if (simpleDraweeView != null) {
                ViewAppcommandsOptiontitleListitemBinding viewAppcommandsOptiontitleListitemBinding = new ViewAppcommandsOptiontitleListitemBinding((ConstraintLayout) view, textView, simpleDraweeView);
                m.checkNotNullExpressionValue(viewAppcommandsOptiontitleListitemBinding, "ViewAppcommandsOptiontit…temBinding.bind(itemView)");
                this.binding = viewAppcommandsOptiontitleListitemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SelectedApplicationCommandItem selectedApplicationCommandItem) {
        onConfigure2(i, selectedApplicationCommandItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SelectedApplicationCommandItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StringBuilder sbQ = a.Q(MentionUtilsKt.SLASH_CHAR);
        sbQ.append(data.getTitle());
        String string = sbQ.toString();
        TextView textView = this.binding.f2173b;
        m.checkNotNullExpressionValue(textView, "binding.appcommandsOptiontitle");
        textView.setText(string);
        this.binding.c.setImageURI((String) null);
        this.binding.c.clearColorFilter();
        Application application = data.getApplication();
        if (application != null) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.appcommandsOptiontitleAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application);
            return;
        }
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        int themedColor = ColorCompat.getThemedColor(constraintLayout, 2130969056);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.appcommandsOptiontitleAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView2, 2131232129, (MGImages$ChangeDetector) null, 4, (Object) null);
        this.binding.c.setColorFilter(themedColor, PorterDuff$Mode.SRC_ATOP);
    }
}
