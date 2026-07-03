package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadBrowserFilterSheetBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserFilterSheet$binding$2 extends C12236k implements Function1<View, WidgetThreadBrowserFilterSheetBinding> {
    public static final WidgetThreadBrowserFilterSheet$binding$2 INSTANCE = new WidgetThreadBrowserFilterSheet$binding$2();

    public WidgetThreadBrowserFilterSheet$binding$2() {
        super(1, WidgetThreadBrowserFilterSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadBrowserFilterSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_profile_sheet_emojis_count;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_profile_sheet_emojis_count);
        if (textView != null) {
            i = C5419R.id.thread_browser_moderator_view;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.thread_browser_moderator_view);
            if (checkedSetting != null) {
                i = C5419R.id.thread_browser_moderator_view_card;
                CardView cardView = (CardView) view.findViewById(C5419R.id.thread_browser_moderator_view_card);
                if (cardView != null) {
                    i = C5419R.id.thread_browser_visibility_private;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.thread_browser_visibility_private);
                    if (checkedSetting2 != null) {
                        i = C5419R.id.thread_browser_visibility_public;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.thread_browser_visibility_public);
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
