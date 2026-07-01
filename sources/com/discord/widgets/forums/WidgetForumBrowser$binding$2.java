package com.discord.widgets.forums;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.o;
import b.a.i.p;
import com.discord.R$id;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumBrowser$binding$2 extends k implements Function1<View, WidgetForumBrowserBinding> {
    public static final WidgetForumBrowser$binding$2 INSTANCE = new WidgetForumBrowser$binding$2();

    public WidgetForumBrowser$binding$2() {
        super(1, WidgetForumBrowserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumBrowserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetForumBrowserBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetForumBrowserBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.action_buttons_guideline;
        Guideline guideline = (Guideline) view.findViewById(R$id.action_buttons_guideline);
        if (guideline != null) {
            i = R$id.create_post;
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view.findViewById(R$id.create_post);
            if (extendedFloatingActionButton != null) {
                i = R$id.empty_view;
                View viewFindViewById = view.findViewById(R$id.empty_view);
                if (viewFindViewById != null) {
                    int i2 = R$id.forum_browser_empty_heading;
                    TextView textView = (TextView) viewFindViewById.findViewById(R$id.forum_browser_empty_heading);
                    if (textView != null) {
                        i2 = R$id.forum_browser_empty_subheading;
                        TextView textView2 = (TextView) viewFindViewById.findViewById(R$id.forum_browser_empty_subheading);
                        if (textView2 != null) {
                            i2 = R$id.forum_icon;
                            ImageView imageView = (ImageView) viewFindViewById.findViewById(R$id.forum_icon);
                            if (imageView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
                                o oVar = new o(constraintLayout, textView, textView2, imageView, constraintLayout);
                                View viewFindViewById2 = view.findViewById(R$id.loading_view);
                                if (viewFindViewById2 != null) {
                                    p pVar = new p((ConstraintLayout) viewFindViewById2);
                                    ViewStub viewStub = (ViewStub) view.findViewById(R$id.nsfw_view);
                                    if (viewStub != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(2131364898);
                                        if (recyclerView != null) {
                                            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R$id.thread_browser_toolbar);
                                            if (appBarLayout != null) {
                                                Barrier barrier = (Barrier) view.findViewById(R$id.top_of_ui);
                                                if (barrier != null) {
                                                    FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.view_guidelines);
                                                    if (floatingActionButton != null) {
                                                        return new WidgetForumBrowserBinding((ConstraintLayout) view, guideline, extendedFloatingActionButton, oVar, pVar, viewStub, recyclerView, appBarLayout, barrier, floatingActionButton);
                                                    }
                                                    i = R$id.view_guidelines;
                                                } else {
                                                    i = R$id.top_of_ui;
                                                }
                                            } else {
                                                i = R$id.thread_browser_toolbar;
                                            }
                                        } else {
                                            i = 2131364898;
                                        }
                                    } else {
                                        i = R$id.nsfw_view;
                                    }
                                } else {
                                    i = R$id.loading_view;
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
