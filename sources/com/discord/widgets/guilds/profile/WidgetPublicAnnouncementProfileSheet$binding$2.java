package com.discord.widgets.guilds.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetAnnouncementGuildProfileSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPublicAnnouncementProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPublicAnnouncementProfileSheet$binding$2 extends C12236k implements Function1<View, WidgetAnnouncementGuildProfileSheetBinding> {
    public static final WidgetPublicAnnouncementProfileSheet$binding$2 INSTANCE = new WidgetPublicAnnouncementProfileSheet$binding$2();

    public WidgetPublicAnnouncementProfileSheet$binding$2() {
        super(1, WidgetAnnouncementGuildProfileSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAnnouncementGuildProfileSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAnnouncementGuildProfileSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.announcement_guild_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.announcement_guild_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.announcement_guild_description;
            TextView textView = (TextView) view.findViewById(C5419R.id.announcement_guild_description);
            if (textView != null) {
                i = C5419R.id.announcement_guild_here_to_help;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.announcement_guild_here_to_help);
                if (textView2 != null) {
                    i = C5419R.id.announcement_guild_name;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.announcement_guild_name);
                    if (textView3 != null) {
                        i = C5419R.id.announcement_guild_staff_icon;
                        ImageView imageView = (ImageView) view.findViewById(C5419R.id.announcement_guild_staff_icon);
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
