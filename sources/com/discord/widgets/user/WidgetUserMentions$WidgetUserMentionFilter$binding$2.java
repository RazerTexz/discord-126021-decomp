package com.discord.widgets.user;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetUserMentionsFilterBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$WidgetUserMentionFilter$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetUserMentionsFilterBinding> {
    public static final WidgetUserMentions$WidgetUserMentionFilter$binding$2 INSTANCE = new WidgetUserMentions$WidgetUserMentionFilter$binding$2();

    public WidgetUserMentions$WidgetUserMentionFilter$binding$2() {
        super(1, WidgetUserMentionsFilterBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMentionsFilterBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.user_mentions_filter_include_everyone;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.user_mentions_filter_include_everyone);
        if (checkedSetting != null) {
            i = R.id.user_mentions_filter_include_roles;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.user_mentions_filter_include_roles);
            if (checkedSetting2 != null) {
                i = R.id.user_mentions_filter_this_server;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.user_mentions_filter_this_server);
                if (checkedSetting3 != null) {
                    return new WidgetUserMentionsFilterBinding((NestedScrollView) view, checkedSetting, checkedSetting2, checkedSetting3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
