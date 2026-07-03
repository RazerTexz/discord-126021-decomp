package com.discord.widgets.share;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetIncomingShareBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.user.search.ViewGlobalSearchItem;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetIncomingShare$binding$2 extends C12236k implements Function1<View, WidgetIncomingShareBinding> {
    public static final WidgetIncomingShare$binding$2 INSTANCE = new WidgetIncomingShare$binding$2();

    public WidgetIncomingShare$binding$2() {
        super(1, WidgetIncomingShareBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetIncomingShareBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetIncomingShareBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.external_share_activity_action_preview;
            ViewEmbedGameInvite viewEmbedGameInvite = (ViewEmbedGameInvite) view.findViewById(C5419R.id.external_share_activity_action_preview);
            if (viewEmbedGameInvite != null) {
                i = C5419R.id.external_share_comment;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.external_share_comment);
                if (textInputLayout != null) {
                    i = C5419R.id.external_share_list;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.external_share_list);
                    if (recyclerView != null) {
                        i = C5419R.id.external_share_list_wrap;
                        CardView cardView = (CardView) view.findViewById(C5419R.id.external_share_list_wrap);
                        if (cardView != null) {
                            i = C5419R.id.external_share_search;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C5419R.id.external_share_search);
                            if (textInputLayout2 != null) {
                                i = C5419R.id.external_share_search_results;
                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.external_share_search_results);
                                if (recyclerView2 != null) {
                                    i = C5419R.id.incoming_share_no_results_img;
                                    ImageView imageView = (ImageView) view.findViewById(C5419R.id.incoming_share_no_results_img);
                                    if (imageView != null) {
                                        i = C5419R.id.incoming_share_results_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.incoming_share_results_flipper);
                                        if (appViewFlipper != null) {
                                            i = C5419R.id.scroll_view;
                                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(C5419R.id.scroll_view);
                                            if (nestedScrollView != null) {
                                                i = C5419R.id.search_flipper;
                                                AppViewFlipper appViewFlipper2 = (AppViewFlipper) view.findViewById(C5419R.id.search_flipper);
                                                if (appViewFlipper2 != null) {
                                                    i = C5419R.id.widget_channel_search_item;
                                                    ViewGlobalSearchItem viewGlobalSearchItem = (ViewGlobalSearchItem) view.findViewById(C5419R.id.widget_channel_search_item);
                                                    if (viewGlobalSearchItem != null) {
                                                        i = C5419R.id.widget_channel_search_item_remove;
                                                        ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.widget_channel_search_item_remove);
                                                        if (imageView2 != null) {
                                                            return new WidgetIncomingShareBinding((CoordinatorLayout) view, dimmerView, viewEmbedGameInvite, textInputLayout, recyclerView, cardView, textInputLayout2, recyclerView2, imageView, appViewFlipper, nestedScrollView, appViewFlipper2, viewGlobalSearchItem, imageView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
