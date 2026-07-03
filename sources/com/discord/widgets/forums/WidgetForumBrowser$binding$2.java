package com.discord.widgets.forums;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1016o;
import p007b.p008a.p025i.C1023p;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumBrowser$binding$2 extends C12236k implements Function1<View, WidgetForumBrowserBinding> {
    public static final WidgetForumBrowser$binding$2 INSTANCE = new WidgetForumBrowser$binding$2();

    public WidgetForumBrowser$binding$2() {
        super(1, WidgetForumBrowserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumBrowserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetForumBrowserBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_buttons_guideline;
        Guideline guideline = (Guideline) view.findViewById(C5419R.id.action_buttons_guideline);
        if (guideline != null) {
            i = C5419R.id.create_post;
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view.findViewById(C5419R.id.create_post);
            if (extendedFloatingActionButton != null) {
                i = C5419R.id.empty_view;
                View viewFindViewById = view.findViewById(C5419R.id.empty_view);
                if (viewFindViewById != null) {
                    int i2 = C5419R.id.forum_browser_empty_heading;
                    TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.forum_browser_empty_heading);
                    if (textView != null) {
                        i2 = C5419R.id.forum_browser_empty_subheading;
                        TextView textView2 = (TextView) viewFindViewById.findViewById(C5419R.id.forum_browser_empty_subheading);
                        if (textView2 != null) {
                            i2 = C5419R.id.forum_icon;
                            ImageView imageView = (ImageView) viewFindViewById.findViewById(C5419R.id.forum_icon);
                            if (imageView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
                                C1016o c1016o = new C1016o(constraintLayout, textView, textView2, imageView, constraintLayout);
                                View viewFindViewById2 = view.findViewById(C5419R.id.loading_view);
                                if (viewFindViewById2 != null) {
                                    C1023p c1023p = new C1023p((ConstraintLayout) viewFindViewById2);
                                    ViewStub viewStub = (ViewStub) view.findViewById(C5419R.id.nsfw_view);
                                    if (viewStub != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
                                        if (recyclerView != null) {
                                            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.thread_browser_toolbar);
                                            if (appBarLayout != null) {
                                                Barrier barrier = (Barrier) view.findViewById(C5419R.id.top_of_ui);
                                                if (barrier != null) {
                                                    FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.view_guidelines);
                                                    if (floatingActionButton != null) {
                                                        return new WidgetForumBrowserBinding((ConstraintLayout) view, guideline, extendedFloatingActionButton, c1016o, c1023p, viewStub, recyclerView, appBarLayout, barrier, floatingActionButton);
                                                    }
                                                    i = C5419R.id.view_guidelines;
                                                } else {
                                                    i = C5419R.id.top_of_ui;
                                                }
                                            } else {
                                                i = C5419R.id.thread_browser_toolbar;
                                            }
                                        } else {
                                            i = C5419R.id.recycler_view;
                                        }
                                    } else {
                                        i = C5419R.id.nsfw_view;
                                    }
                                } else {
                                    i = C5419R.id.loading_view;
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
