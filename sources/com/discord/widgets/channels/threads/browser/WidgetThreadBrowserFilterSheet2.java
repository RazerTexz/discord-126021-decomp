package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetThreadBrowserFilterSheetBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserFilterSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserFilterSheetBinding> {
    public static final WidgetThreadBrowserFilterSheet2 INSTANCE = new WidgetThreadBrowserFilterSheet2();

    public WidgetThreadBrowserFilterSheet2() {
        super(1, WidgetThreadBrowserFilterSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadBrowserFilterSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_profile_sheet_emojis_count;
        TextView textView = (TextView) view.findViewById(R.id.guild_profile_sheet_emojis_count);
        if (textView != null) {
            i = R.id.thread_browser_moderator_view;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.thread_browser_moderator_view);
            if (checkedSetting != null) {
                i = R.id.thread_browser_moderator_view_card;
                CardView cardView = (CardView) view.findViewById(R.id.thread_browser_moderator_view_card);
                if (cardView != null) {
                    i = R.id.thread_browser_visibility_private;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.thread_browser_visibility_private);
                    if (checkedSetting2 != null) {
                        i = R.id.thread_browser_visibility_public;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.thread_browser_visibility_public);
                        if (checkedSetting3 != null) {
                            return new WidgetThreadBrowserFilterSheetBinding((NestedScrollView) view, textView, checkedSetting, cardView, checkedSetting2, checkedSetting3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
