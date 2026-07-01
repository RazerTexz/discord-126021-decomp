package com.discord.widgets.chat.input.applicationcommands;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewAppcommandsOptiontitleListitemBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.MentionUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandTitleAdapterItem, reason: use source file name */
/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter5 extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandAdapter8> {
    private final ViewAppcommandsOptiontitleListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter5(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(R.layout.view_appcommands_optiontitle_listitem, selectedApplicationCommandAdapter);
        Intrinsics3.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.appcommands_optiontitle;
        TextView textView = (TextView) view.findViewById(R.id.appcommands_optiontitle);
        if (textView != null) {
            i = R.id.appcommands_optiontitle_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.appcommands_optiontitle_avatar);
            if (simpleDraweeView != null) {
                ViewAppcommandsOptiontitleListitemBinding viewAppcommandsOptiontitleListitemBinding = new ViewAppcommandsOptiontitleListitemBinding((ConstraintLayout) view, textView, simpleDraweeView);
                Intrinsics3.checkNotNullExpressionValue(viewAppcommandsOptiontitleListitemBinding, "ViewAppcommandsOptiontit…temBinding.bind(itemView)");
                this.binding = viewAppcommandsOptiontitleListitemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, SelectedApplicationCommandAdapter8 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
        sbQ.append(data.getTitle());
        String string = sbQ.toString();
        TextView textView = this.binding.f2173b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.appcommandsOptiontitle");
        textView.setText(string);
        this.binding.c.setImageURI((String) null);
        this.binding.c.clearColorFilter();
        Application application = data.getApplication();
        if (application != null) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.appcommandsOptiontitleAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application);
            return;
        }
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        int themedColor = ColorCompat.getThemedColor(constraintLayout, R.attr.colorTextMuted);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.appcommandsOptiontitleAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView2, R.drawable.ic_slash_command_24dp, (MGImages.ChangeDetector) null, 4, (Object) null);
        this.binding.c.setColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP);
    }
}
