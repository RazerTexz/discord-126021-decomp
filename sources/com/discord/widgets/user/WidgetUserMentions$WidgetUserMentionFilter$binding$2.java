package com.discord.widgets.user;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserMentionsFilterBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$WidgetUserMentionFilter$binding$2 extends C12236k implements Function1<View, WidgetUserMentionsFilterBinding> {
    public static final WidgetUserMentions$WidgetUserMentionFilter$binding$2 INSTANCE = new WidgetUserMentions$WidgetUserMentionFilter$binding$2();

    public WidgetUserMentions$WidgetUserMentionFilter$binding$2() {
        super(1, WidgetUserMentionsFilterBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMentionsFilterBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.user_mentions_filter_include_everyone;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.user_mentions_filter_include_everyone);
        if (checkedSetting != null) {
            i = C5419R.id.user_mentions_filter_include_roles;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.user_mentions_filter_include_roles);
            if (checkedSetting2 != null) {
                i = C5419R.id.user_mentions_filter_this_server;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.user_mentions_filter_this_server);
                if (checkedSetting3 != null) {
                    return new WidgetUserMentionsFilterBinding((NestedScrollView) view, checkedSetting, checkedSetting2, checkedSetting3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
