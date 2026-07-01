package com.discord.widgets.guilds.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetAnnouncementGuildProfileSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetPublicAnnouncementProfileSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPublicAnnouncementProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPublicAnnouncementProfileSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetAnnouncementGuildProfileSheetBinding> {
    public static final WidgetPublicAnnouncementProfileSheet2 INSTANCE = new WidgetPublicAnnouncementProfileSheet2();

    public WidgetPublicAnnouncementProfileSheet2() {
        super(1, WidgetAnnouncementGuildProfileSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAnnouncementGuildProfileSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAnnouncementGuildProfileSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.announcement_guild_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.announcement_guild_avatar);
        if (simpleDraweeView != null) {
            i = R.id.announcement_guild_description;
            TextView textView = (TextView) view.findViewById(R.id.announcement_guild_description);
            if (textView != null) {
                i = R.id.announcement_guild_here_to_help;
                TextView textView2 = (TextView) view.findViewById(R.id.announcement_guild_here_to_help);
                if (textView2 != null) {
                    i = R.id.announcement_guild_name;
                    TextView textView3 = (TextView) view.findViewById(R.id.announcement_guild_name);
                    if (textView3 != null) {
                        i = R.id.announcement_guild_staff_icon;
                        ImageView imageView = (ImageView) view.findViewById(R.id.announcement_guild_staff_icon);
                        if (imageView != null) {
                            return new WidgetAnnouncementGuildProfileSheetBinding((NestedScrollView) view, simpleDraweeView, textView, textView2, textView3, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
