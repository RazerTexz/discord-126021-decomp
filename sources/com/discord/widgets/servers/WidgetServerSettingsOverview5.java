package com.discord.widgets.servers;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.ViewServerSettingsIconNameBinding;
import b.a.i.ViewServerSettingsNotificationsBinding;
import b.a.i.ViewServerSettingsSystemChannelWrapBinding;
import b.a.i.ViewServerSettingsUploadBannerAnimatedUpsellBinding;
import b.a.i.ViewServerSettingsUploadBannerBinding;
import b.a.i.ViewServerSettingsUploadSplashBinding;
import b.a.i.WidgetServerSettingsOverviewSectionAfkChannelBinding;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsOverviewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsOverview5 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsOverviewBinding> {
    public static final WidgetServerSettingsOverview5 INSTANCE = new WidgetServerSettingsOverview5();

    public WidgetServerSettingsOverview5() {
        super(1, WidgetServerSettingsOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsOverviewBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.afk;
        View viewFindViewById = view.findViewById(R.id.afk);
        if (viewFindViewById != null) {
            int i2 = R.id.afk_channel;
            TextView textView = (TextView) viewFindViewById.findViewById(R.id.afk_channel);
            if (textView != null) {
                i2 = R.id.afk_channel_wrap;
                LinearLayout linearLayout = (LinearLayout) viewFindViewById.findViewById(R.id.afk_channel_wrap);
                if (linearLayout != null) {
                    i2 = R.id.afk_timeout;
                    TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.afk_timeout);
                    if (textView2 != null) {
                        i2 = R.id.afk_timeout_wrap;
                        LinearLayout linearLayout2 = (LinearLayout) viewFindViewById.findViewById(R.id.afk_timeout_wrap);
                        if (linearLayout2 != null) {
                            WidgetServerSettingsOverviewSectionAfkChannelBinding widgetServerSettingsOverviewSectionAfkChannelBinding = new WidgetServerSettingsOverviewSectionAfkChannelBinding((LinearLayout) viewFindViewById, textView, linearLayout, textView2, linearLayout2);
                            i = R.id.header;
                            View viewFindViewById2 = view.findViewById(R.id.header);
                            if (viewFindViewById2 != null) {
                                int i3 = R.id.icon_label;
                                TextView textView3 = (TextView) viewFindViewById2.findViewById(R.id.icon_label);
                                if (textView3 != null) {
                                    i3 = R.id.overview_name;
                                    TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById2.findViewById(R.id.overview_name);
                                    if (textInputLayout != null) {
                                        i3 = R.id.server_settings_overview_icon;
                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewFindViewById2.findViewById(R.id.server_settings_overview_icon);
                                        if (simpleDraweeView != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById2;
                                            i3 = R.id.server_settings_overview_icon_remove;
                                            TextView textView4 = (TextView) viewFindViewById2.findViewById(R.id.server_settings_overview_icon_remove);
                                            if (textView4 != null) {
                                                i3 = R.id.server_settings_overview_icon_text;
                                                TextView textView5 = (TextView) viewFindViewById2.findViewById(R.id.server_settings_overview_icon_text);
                                                if (textView5 != null) {
                                                    ViewServerSettingsIconNameBinding viewServerSettingsIconNameBinding = new ViewServerSettingsIconNameBinding(constraintLayout, textView3, textInputLayout, simpleDraweeView, constraintLayout, textView4, textView5);
                                                    i = R.id.notifications;
                                                    View viewFindViewById3 = view.findViewById(R.id.notifications);
                                                    if (viewFindViewById3 != null) {
                                                        int i4 = R.id.server_settings_overview_notification_all;
                                                        CheckedSetting checkedSetting = (CheckedSetting) viewFindViewById3.findViewById(R.id.server_settings_overview_notification_all);
                                                        if (checkedSetting != null) {
                                                            i4 = R.id.server_settings_overview_notification_only_mentions;
                                                            CheckedSetting checkedSetting2 = (CheckedSetting) viewFindViewById3.findViewById(R.id.server_settings_overview_notification_only_mentions);
                                                            if (checkedSetting2 != null) {
                                                                ViewServerSettingsNotificationsBinding viewServerSettingsNotificationsBinding = new ViewServerSettingsNotificationsBinding((LinearLayout) viewFindViewById3, checkedSetting, checkedSetting2);
                                                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.save);
                                                                if (floatingActionButton != null) {
                                                                    ScrollView scrollView = (ScrollView) view.findViewById(R.id.server_settings_overview_scroll);
                                                                    if (scrollView != null) {
                                                                        View viewFindViewById4 = view.findViewById(R.id.systemChannel);
                                                                        if (viewFindViewById4 != null) {
                                                                            int i5 = R.id.system_channel;
                                                                            TextView textView6 = (TextView) viewFindViewById4.findViewById(R.id.system_channel);
                                                                            if (textView6 != null) {
                                                                                i5 = R.id.system_channel_boost;
                                                                                CheckedSetting checkedSetting3 = (CheckedSetting) viewFindViewById4.findViewById(R.id.system_channel_boost);
                                                                                if (checkedSetting3 != null) {
                                                                                    i5 = R.id.system_channel_join;
                                                                                    CheckedSetting checkedSetting4 = (CheckedSetting) viewFindViewById4.findViewById(R.id.system_channel_join);
                                                                                    if (checkedSetting4 != null) {
                                                                                        i5 = R.id.system_channel_join_replies;
                                                                                        CheckedSetting checkedSetting5 = (CheckedSetting) viewFindViewById4.findViewById(R.id.system_channel_join_replies);
                                                                                        if (checkedSetting5 != null) {
                                                                                            LinearLayout linearLayout3 = (LinearLayout) viewFindViewById4;
                                                                                            ViewServerSettingsSystemChannelWrapBinding viewServerSettingsSystemChannelWrapBinding = new ViewServerSettingsSystemChannelWrapBinding(linearLayout3, textView6, checkedSetting3, checkedSetting4, checkedSetting5, linearLayout3);
                                                                                            View viewFindViewById5 = view.findViewById(R.id.uploadBanner);
                                                                                            if (viewFindViewById5 != null) {
                                                                                                int i6 = R.id.animated_banner_upsell;
                                                                                                View viewFindViewById6 = viewFindViewById5.findViewById(R.id.animated_banner_upsell);
                                                                                                if (viewFindViewById6 != null) {
                                                                                                    int i7 = R.id.animated_banner_upsell_button;
                                                                                                    MaterialButton materialButton = (MaterialButton) viewFindViewById6.findViewById(R.id.animated_banner_upsell_button);
                                                                                                    if (materialButton != null) {
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) viewFindViewById6;
                                                                                                        TextView textView7 = (TextView) viewFindViewById6.findViewById(R.id.animated_banner_upsell_text);
                                                                                                        if (textView7 != null) {
                                                                                                            ViewServerSettingsUploadBannerAnimatedUpsellBinding viewServerSettingsUploadBannerAnimatedUpsellBinding = new ViewServerSettingsUploadBannerAnimatedUpsellBinding(linearLayout4, materialButton, linearLayout4, textView7);
                                                                                                            i6 = R.id.server_settings_overview_upload_banner_container;
                                                                                                            FrameLayout frameLayout = (FrameLayout) viewFindViewById5.findViewById(R.id.server_settings_overview_upload_banner_container);
                                                                                                            if (frameLayout != null) {
                                                                                                                i6 = R.id.server_settings_overview_upload_banner_remove;
                                                                                                                TextView textView8 = (TextView) viewFindViewById5.findViewById(R.id.server_settings_overview_upload_banner_remove);
                                                                                                                if (textView8 != null) {
                                                                                                                    i6 = R.id.upload_banner;
                                                                                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewFindViewById5.findViewById(R.id.upload_banner);
                                                                                                                    if (simpleDraweeView2 != null) {
                                                                                                                        i6 = R.id.upload_banner_fab;
                                                                                                                        FloatingActionButton floatingActionButton2 = (FloatingActionButton) viewFindViewById5.findViewById(R.id.upload_banner_fab);
                                                                                                                        if (floatingActionButton2 != null) {
                                                                                                                            i6 = R.id.upload_banner_learn_more;
                                                                                                                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById5.findViewById(R.id.upload_banner_learn_more);
                                                                                                                            if (linkifiedTextView != null) {
                                                                                                                                i6 = R.id.upload_banner_nitro_tier;
                                                                                                                                TextView textView9 = (TextView) viewFindViewById5.findViewById(R.id.upload_banner_nitro_tier);
                                                                                                                                if (textView9 != null) {
                                                                                                                                    i6 = R.id.upload_banner_unlock;
                                                                                                                                    TextView textView10 = (TextView) viewFindViewById5.findViewById(R.id.upload_banner_unlock);
                                                                                                                                    if (textView10 != null) {
                                                                                                                                        ViewServerSettingsUploadBannerBinding viewServerSettingsUploadBannerBinding = new ViewServerSettingsUploadBannerBinding((LinearLayout) viewFindViewById5, viewServerSettingsUploadBannerAnimatedUpsellBinding, frameLayout, textView8, simpleDraweeView2, floatingActionButton2, linkifiedTextView, textView9, textView10);
                                                                                                                                        View viewFindViewById7 = view.findViewById(R.id.uploadSplash);
                                                                                                                                        if (viewFindViewById7 != null) {
                                                                                                                                            int i8 = R.id.server_settings_overview_upload_splash_container;
                                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) viewFindViewById7.findViewById(R.id.server_settings_overview_upload_splash_container);
                                                                                                                                            if (frameLayout2 != null) {
                                                                                                                                                i8 = R.id.server_settings_overview_upload_splash_fab;
                                                                                                                                                FloatingActionButton floatingActionButton3 = (FloatingActionButton) viewFindViewById7.findViewById(R.id.server_settings_overview_upload_splash_fab);
                                                                                                                                                if (floatingActionButton3 != null) {
                                                                                                                                                    i8 = R.id.server_settings_overview_upload_splash_remove;
                                                                                                                                                    TextView textView11 = (TextView) viewFindViewById7.findViewById(R.id.server_settings_overview_upload_splash_remove);
                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                        i8 = R.id.upload_splash;
                                                                                                                                                        SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewFindViewById7.findViewById(R.id.upload_splash);
                                                                                                                                                        if (simpleDraweeView3 != null) {
                                                                                                                                                            i8 = R.id.upload_splash_learn_more;
                                                                                                                                                            LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewFindViewById7.findViewById(R.id.upload_splash_learn_more);
                                                                                                                                                            if (linkifiedTextView2 != null) {
                                                                                                                                                                i8 = R.id.upload_splash_nitro_tier;
                                                                                                                                                                TextView textView12 = (TextView) viewFindViewById7.findViewById(R.id.upload_splash_nitro_tier);
                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                    i8 = R.id.upload_splash_unlock;
                                                                                                                                                                    TextView textView13 = (TextView) viewFindViewById7.findViewById(R.id.upload_splash_unlock);
                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                        return new WidgetServerSettingsOverviewBinding((CoordinatorLayout) view, widgetServerSettingsOverviewSectionAfkChannelBinding, viewServerSettingsIconNameBinding, viewServerSettingsNotificationsBinding, floatingActionButton, scrollView, viewServerSettingsSystemChannelWrapBinding, viewServerSettingsUploadBannerBinding, new ViewServerSettingsUploadSplashBinding((LinearLayout) viewFindViewById7, frameLayout2, floatingActionButton3, textView11, simpleDraweeView3, linkifiedTextView2, textView12, textView13));
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById7.getResources().getResourceName(i8)));
                                                                                                                                        }
                                                                                                                                        i = R.id.uploadSplash;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        } else {
                                                                                                            i7 = R.id.animated_banner_upsell_text;
                                                                                                        }
                                                                                                    }
                                                                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById6.getResources().getResourceName(i7)));
                                                                                                }
                                                                                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById5.getResources().getResourceName(i6)));
                                                                                            }
                                                                                            i = R.id.uploadBanner;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById4.getResources().getResourceName(i5)));
                                                                        }
                                                                        i = R.id.systemChannel;
                                                                    } else {
                                                                        i = R.id.server_settings_overview_scroll;
                                                                    }
                                                                } else {
                                                                    i = R.id.save;
                                                                }
                                                            }
                                                        }
                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i4)));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i3)));
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
