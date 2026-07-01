package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.i.WidgetMusicRichPresenceBinding;
import b.a.i.WidgetPlatformRichPresenceBinding;
import b.a.i.WidgetStageChannelRichPresenceBinding;
import b.a.i.WidgetStreamRichPresenceBinding;
import b.a.i.WidgetUserRichPresenceBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.app.AppComponent;
import com.discord.models.user.User;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StreamPreviewView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public class ViewHolderUserRichPresence {
    public static final int BASE_RICH_PRESENCE_TYPE = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int GAME_RICH_PRESENCE_TYPE = 1;
    public static final int MUSIC_RICH_PRESENCE_TYPE = 2;
    public static final int PLATFORM_RICH_PRESENCE_TYPE = 3;
    public static final int STAGE_CHANNEL_RICH_PRESENCE_TYPE = 5;
    public static final int STREAM_RICH_PRESENCE_TYPE = 4;
    private Function5<? super Context, ? super Long, ? super String, ? super Long, ? super Integer, Unit> onActivityCustomButtonClicked;
    private Subscription perSecondTimerSubscription;
    private final TextView richPresenceDetails;
    private final TextView richPresenceHeader;
    private final SimpleDraweeView richPresenceImageLarge;
    private final SimpleDraweeView richPresenceImageSmall;
    private final Button richPresencePrimaryButton;
    private final Button richPresenceSecondaryButton;
    private final TextView richPresenceState;
    private final View richPresenceTextContainer;
    private final TextView richPresenceTime;
    private final TextView richPresenceTitle;
    private final int richPresenceType;
    private final View root;

    /* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
    public static final class Companion {
        private Companion() {
        }

        private final ViewHolderUserRichPresence createRPView(ViewGroup parent, int type) {
            String str;
            int i;
            int i2;
            ViewHolderUserRichPresence viewHolderPlatformRichPresence;
            String str2;
            int i3;
            String str3;
            int i4;
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
            if (type == 1) {
                WidgetUserRichPresenceBinding widgetUserRichPresenceBindingA = WidgetUserRichPresenceBinding.a(layoutInflaterFrom, parent, true);
                Intrinsics3.checkNotNullExpressionValue(widgetUserRichPresenceBindingA, "WidgetUserRichPresenceBi…e(inflater, parent, true)");
                SimpleDraweeView simpleDraweeView = widgetUserRichPresenceBindingA.e;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.richPresenceImageLarge");
                SimpleDraweeView simpleDraweeView2 = widgetUserRichPresenceBindingA.f;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.richPresenceImageSmall");
                TextView textView = widgetUserRichPresenceBindingA.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.richPresenceHeader");
                TextView textView2 = widgetUserRichPresenceBindingA.k;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.richPresenceTitle");
                TextView textView3 = widgetUserRichPresenceBindingA.c;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.richPresenceDetails");
                TextView textView4 = widgetUserRichPresenceBindingA.j;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.richPresenceTime");
                TextView textView5 = widgetUserRichPresenceBindingA.i;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.richPresenceState");
                LinearLayout linearLayout = widgetUserRichPresenceBindingA.f122b;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.richPresenceContainerData");
                MaterialButton materialButton = widgetUserRichPresenceBindingA.g;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.richPresencePrimaryButton");
                MaterialButton materialButton2 = widgetUserRichPresenceBindingA.h;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.richPresenceSecondaryButton");
                return new ViewHolderGameRichPresence(parent, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, textView5, linearLayout, materialButton, materialButton2);
            }
            if (type == 2) {
                View viewInflate = layoutInflaterFrom.inflate(R.layout.widget_music_rich_presence, parent, false);
                parent.addView(viewInflate);
                Barrier barrier = (Barrier) viewInflate.findViewById(R.id.barrier);
                if (barrier != null) {
                    Space space = (Space) viewInflate.findViewById(R.id.image_bottom_guideline);
                    if (space != null) {
                        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.rich_presence_container_data);
                        if (linearLayout2 != null) {
                            TextView textView6 = (TextView) viewInflate.findViewById(R.id.rich_presence_details);
                            if (textView6 != null) {
                                TextView textView7 = (TextView) viewInflate.findViewById(R.id.rich_presence_header);
                                if (textView7 != null) {
                                    i = R.id.rich_presence_image_large;
                                    SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewInflate.findViewById(R.id.rich_presence_image_large);
                                    if (simpleDraweeView3 != null) {
                                        SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) viewInflate.findViewById(R.id.rich_presence_image_small);
                                        if (simpleDraweeView4 != null) {
                                            TextView textView8 = (TextView) viewInflate.findViewById(R.id.rich_presence_music_duration);
                                            str = "Missing required view with ID: ";
                                            if (textView8 != null) {
                                                TextView textView9 = (TextView) viewInflate.findViewById(R.id.rich_presence_music_elapsed);
                                                if (textView9 != null) {
                                                    FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.rich_presence_music_progress_container);
                                                    if (frameLayout != null) {
                                                        MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.rich_presence_primary_button);
                                                        if (materialButton3 != null) {
                                                            SeekBar seekBar = (SeekBar) viewInflate.findViewById(R.id.rich_presence_seekbar);
                                                            if (seekBar != null) {
                                                                TextView textView10 = (TextView) viewInflate.findViewById(R.id.rich_presence_time);
                                                                if (textView10 != null) {
                                                                    TextView textView11 = (TextView) viewInflate.findViewById(R.id.rich_presence_title);
                                                                    if (textView11 != null) {
                                                                        Intrinsics3.checkNotNullExpressionValue(new WidgetMusicRichPresenceBinding((LinearLayout) viewInflate, barrier, space, linearLayout2, textView6, textView7, simpleDraweeView3, simpleDraweeView4, textView8, textView9, frameLayout, materialButton3, seekBar, textView10, textView11), "WidgetMusicRichPresenceB…e(inflater, parent, true)");
                                                                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.richPresenceImageLarge");
                                                                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.richPresenceImageSmall");
                                                                        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.richPresenceHeader");
                                                                        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.richPresenceTitle");
                                                                        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.richPresenceDetails");
                                                                        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.richPresenceTime");
                                                                        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.richPresenceContainerData");
                                                                        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.richPresencePrimaryButton");
                                                                        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.richPresenceSeekbar");
                                                                        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.richPresenceMusicDuration");
                                                                        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.richPresenceMusicElapsed");
                                                                        return new ViewHolderMusicRichPresence(parent, simpleDraweeView3, simpleDraweeView4, textView7, textView11, textView6, textView10, linearLayout2, materialButton3, seekBar, textView8, textView9);
                                                                    }
                                                                    i = R.id.rich_presence_title;
                                                                } else {
                                                                    i = R.id.rich_presence_time;
                                                                }
                                                            } else {
                                                                i = R.id.rich_presence_seekbar;
                                                            }
                                                        } else {
                                                            i = R.id.rich_presence_primary_button;
                                                        }
                                                    } else {
                                                        i = R.id.rich_presence_music_progress_container;
                                                    }
                                                } else {
                                                    i = R.id.rich_presence_music_elapsed;
                                                }
                                            } else {
                                                i = R.id.rich_presence_music_duration;
                                            }
                                        } else {
                                            str = "Missing required view with ID: ";
                                            i = R.id.rich_presence_image_small;
                                        }
                                    } else {
                                        str = "Missing required view with ID: ";
                                    }
                                } else {
                                    str = "Missing required view with ID: ";
                                    i = R.id.rich_presence_header;
                                }
                            } else {
                                str = "Missing required view with ID: ";
                                i = R.id.rich_presence_details;
                            }
                        } else {
                            str = "Missing required view with ID: ";
                            i = R.id.rich_presence_container_data;
                        }
                    } else {
                        str = "Missing required view with ID: ";
                        i = R.id.image_bottom_guideline;
                    }
                } else {
                    str = "Missing required view with ID: ";
                    i = R.id.barrier;
                }
                throw new NullPointerException(str.concat(viewInflate.getResources().getResourceName(i)));
            }
            if (type == 3) {
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.widget_platform_rich_presence, parent, false);
                parent.addView(viewInflate2);
                Barrier barrier2 = (Barrier) viewInflate2.findViewById(R.id.barrier);
                if (barrier2 != null) {
                    Space space2 = (Space) viewInflate2.findViewById(R.id.image_bottom_guideline);
                    if (space2 != null) {
                        LinearLayout linearLayout3 = (LinearLayout) viewInflate2.findViewById(R.id.rich_presence_container_data);
                        if (linearLayout3 != null) {
                            TextView textView12 = (TextView) viewInflate2.findViewById(R.id.rich_presence_header);
                            if (textView12 != null) {
                                SimpleDraweeView simpleDraweeView5 = (SimpleDraweeView) viewInflate2.findViewById(R.id.rich_presence_image_large);
                                if (simpleDraweeView5 != null) {
                                    SimpleDraweeView simpleDraweeView6 = (SimpleDraweeView) viewInflate2.findViewById(R.id.rich_presence_image_small);
                                    if (simpleDraweeView6 != null) {
                                        MaterialButton materialButton4 = (MaterialButton) viewInflate2.findViewById(R.id.rich_presence_primary_button);
                                        if (materialButton4 != null) {
                                            TextView textView13 = (TextView) viewInflate2.findViewById(R.id.rich_presence_time);
                                            if (textView13 != null) {
                                                TextView textView14 = (TextView) viewInflate2.findViewById(R.id.rich_presence_title);
                                                if (textView14 != null) {
                                                    Intrinsics3.checkNotNullExpressionValue(new WidgetPlatformRichPresenceBinding((LinearLayout) viewInflate2, barrier2, space2, linearLayout3, textView12, simpleDraweeView5, simpleDraweeView6, materialButton4, textView13, textView14), "WidgetPlatformRichPresen…e(inflater, parent, true)");
                                                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.richPresenceImageLarge");
                                                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.richPresenceImageSmall");
                                                    Intrinsics3.checkNotNullExpressionValue(textView12, "binding.richPresenceHeader");
                                                    Intrinsics3.checkNotNullExpressionValue(textView14, "binding.richPresenceTitle");
                                                    Intrinsics3.checkNotNullExpressionValue(textView13, "binding.richPresenceTime");
                                                    Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.richPresenceContainerData");
                                                    Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.richPresencePrimaryButton");
                                                    viewHolderPlatformRichPresence = new ViewHolderPlatformRichPresence(parent, simpleDraweeView5, simpleDraweeView6, textView12, textView14, textView13, linearLayout3, materialButton4);
                                                } else {
                                                    i2 = R.id.rich_presence_title;
                                                }
                                            } else {
                                                i2 = R.id.rich_presence_time;
                                            }
                                        } else {
                                            i2 = R.id.rich_presence_primary_button;
                                        }
                                    } else {
                                        i2 = R.id.rich_presence_image_small;
                                    }
                                } else {
                                    i2 = R.id.rich_presence_image_large;
                                }
                            } else {
                                i2 = R.id.rich_presence_header;
                            }
                        } else {
                            i2 = R.id.rich_presence_container_data;
                        }
                    } else {
                        i2 = R.id.image_bottom_guideline;
                    }
                } else {
                    i2 = R.id.barrier;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
            }
            if (type == 4) {
                View viewInflate3 = layoutInflaterFrom.inflate(R.layout.widget_stream_rich_presence, parent, false);
                parent.addView(viewInflate3);
                LinearLayout linearLayout4 = (LinearLayout) viewInflate3.findViewById(R.id.rich_presence_container_data);
                if (linearLayout4 != null) {
                    TextView textView15 = (TextView) viewInflate3.findViewById(R.id.rich_presence_details);
                    if (textView15 != null) {
                        TextView textView16 = (TextView) viewInflate3.findViewById(R.id.rich_presence_header);
                        if (textView16 != null) {
                            SimpleDraweeView simpleDraweeView7 = (SimpleDraweeView) viewInflate3.findViewById(R.id.rich_presence_image_large);
                            if (simpleDraweeView7 != null) {
                                TextView textView17 = (TextView) viewInflate3.findViewById(R.id.rich_presence_state);
                                if (textView17 != null) {
                                    TextView textView18 = (TextView) viewInflate3.findViewById(R.id.rich_presence_time);
                                    if (textView18 != null) {
                                        TextView textView19 = (TextView) viewInflate3.findViewById(R.id.rich_presence_title);
                                        str2 = "Missing required view with ID: ";
                                        if (textView19 != null) {
                                            StreamPreviewView streamPreviewView = (StreamPreviewView) viewInflate3.findViewById(R.id.stream_preview);
                                            if (streamPreviewView != null) {
                                                Intrinsics3.checkNotNullExpressionValue(new WidgetStreamRichPresenceBinding((ConstraintLayout) viewInflate3, linearLayout4, textView15, textView16, simpleDraweeView7, textView17, textView18, textView19, streamPreviewView), "WidgetStreamRichPresence…e(inflater, parent, true)");
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView7, "binding.richPresenceImageLarge");
                                                Intrinsics3.checkNotNullExpressionValue(textView16, "binding.richPresenceHeader");
                                                Intrinsics3.checkNotNullExpressionValue(textView19, "binding.richPresenceTitle");
                                                Intrinsics3.checkNotNullExpressionValue(textView15, "binding.richPresenceDetails");
                                                Intrinsics3.checkNotNullExpressionValue(textView18, "binding.richPresenceTime");
                                                Intrinsics3.checkNotNullExpressionValue(textView17, "binding.richPresenceState");
                                                Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.richPresenceContainerData");
                                                Intrinsics3.checkNotNullExpressionValue(streamPreviewView, "binding.streamPreview");
                                                viewHolderPlatformRichPresence = new ViewHolderStreamRichPresence(parent, simpleDraweeView7, textView16, textView19, textView15, textView18, textView17, linearLayout4, streamPreviewView);
                                            } else {
                                                i3 = R.id.stream_preview;
                                            }
                                        } else {
                                            i3 = R.id.rich_presence_title;
                                        }
                                    } else {
                                        str2 = "Missing required view with ID: ";
                                        i3 = R.id.rich_presence_time;
                                    }
                                } else {
                                    str2 = "Missing required view with ID: ";
                                    i3 = R.id.rich_presence_state;
                                }
                            } else {
                                str2 = "Missing required view with ID: ";
                                i3 = R.id.rich_presence_image_large;
                            }
                        } else {
                            str2 = "Missing required view with ID: ";
                            i3 = R.id.rich_presence_header;
                        }
                    } else {
                        str2 = "Missing required view with ID: ";
                        i3 = R.id.rich_presence_details;
                    }
                } else {
                    str2 = "Missing required view with ID: ";
                    i3 = R.id.rich_presence_container_data;
                }
                throw new NullPointerException(str2.concat(viewInflate3.getResources().getResourceName(i3)));
            }
            if (type != 5) {
                WidgetUserRichPresenceBinding widgetUserRichPresenceBindingA2 = WidgetUserRichPresenceBinding.a(layoutInflaterFrom, parent, true);
                Intrinsics3.checkNotNullExpressionValue(widgetUserRichPresenceBindingA2, "WidgetUserRichPresenceBi…e(inflater, parent, true)");
                SimpleDraweeView simpleDraweeView8 = widgetUserRichPresenceBindingA2.e;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView8, "binding.richPresenceImageLarge");
                SimpleDraweeView simpleDraweeView9 = widgetUserRichPresenceBindingA2.f;
                TextView textView20 = widgetUserRichPresenceBindingA2.d;
                Intrinsics3.checkNotNullExpressionValue(textView20, "binding.richPresenceHeader");
                TextView textView21 = widgetUserRichPresenceBindingA2.k;
                Intrinsics3.checkNotNullExpressionValue(textView21, "binding.richPresenceTitle");
                TextView textView22 = widgetUserRichPresenceBindingA2.c;
                TextView textView23 = widgetUserRichPresenceBindingA2.j;
                Intrinsics3.checkNotNullExpressionValue(textView23, "binding.richPresenceTime");
                TextView textView24 = widgetUserRichPresenceBindingA2.i;
                LinearLayout linearLayout5 = widgetUserRichPresenceBindingA2.f122b;
                Intrinsics3.checkNotNullExpressionValue(linearLayout5, "binding.richPresenceContainerData");
                return new ViewHolderUserRichPresence(parent, simpleDraweeView8, simpleDraweeView9, textView20, textView21, textView22, textView23, textView24, linearLayout5, widgetUserRichPresenceBindingA2.g, widgetUserRichPresenceBindingA2.h, 0, 2048, null);
            }
            View viewInflate4 = layoutInflaterFrom.inflate(R.layout.widget_stage_channel_rich_presence, parent, false);
            parent.addView(viewInflate4);
            Barrier barrier3 = (Barrier) viewInflate4.findViewById(R.id.barrier);
            if (barrier3 != null) {
                Space space3 = (Space) viewInflate4.findViewById(R.id.image_bottom_guideline);
                if (space3 != null) {
                    LinearLayout linearLayout6 = (LinearLayout) viewInflate4.findViewById(R.id.rich_presence_container_data);
                    if (linearLayout6 != null) {
                        TextView textView25 = (TextView) viewInflate4.findViewById(R.id.rich_presence_details);
                        if (textView25 != null) {
                            TextView textView26 = (TextView) viewInflate4.findViewById(R.id.rich_presence_header);
                            if (textView26 != null) {
                                SimpleDraweeView simpleDraweeView10 = (SimpleDraweeView) viewInflate4.findViewById(R.id.rich_presence_image_large);
                                if (simpleDraweeView10 != null) {
                                    TextView textView27 = (TextView) viewInflate4.findViewById(R.id.rich_presence_image_large_text);
                                    if (textView27 != null) {
                                        FrameLayout frameLayout2 = (FrameLayout) viewInflate4.findViewById(R.id.rich_presence_image_large_wrap);
                                        if (frameLayout2 != null) {
                                            MaterialButton materialButton5 = (MaterialButton) viewInflate4.findViewById(R.id.rich_presence_primary_button);
                                            if (materialButton5 != null) {
                                                TextView textView28 = (TextView) viewInflate4.findViewById(R.id.rich_presence_time);
                                                str3 = "Missing required view with ID: ";
                                                if (textView28 != null) {
                                                    TextView textView29 = (TextView) viewInflate4.findViewById(R.id.rich_presence_title);
                                                    if (textView29 != null) {
                                                        Intrinsics3.checkNotNullExpressionValue(new WidgetStageChannelRichPresenceBinding((LinearLayout) viewInflate4, barrier3, space3, linearLayout6, textView25, textView26, simpleDraweeView10, textView27, frameLayout2, materialButton5, textView28, textView29), "WidgetStageChannelRichPr…e(inflater, parent, true)");
                                                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView10, "binding.richPresenceImageLarge");
                                                        Intrinsics3.checkNotNullExpressionValue(textView26, "binding.richPresenceHeader");
                                                        Intrinsics3.checkNotNullExpressionValue(textView29, "binding.richPresenceTitle");
                                                        Intrinsics3.checkNotNullExpressionValue(textView25, "binding.richPresenceDetails");
                                                        Intrinsics3.checkNotNullExpressionValue(textView28, "binding.richPresenceTime");
                                                        Intrinsics3.checkNotNullExpressionValue(linearLayout6, "binding.richPresenceContainerData");
                                                        Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.richPresencePrimaryButton");
                                                        Intrinsics3.checkNotNullExpressionValue(textView27, "binding.richPresenceImageLargeText");
                                                        viewHolderPlatformRichPresence = new ViewHolderStageChannelRichPresence(parent, simpleDraweeView10, textView26, textView29, textView25, textView28, linearLayout6, materialButton5, textView27);
                                                    } else {
                                                        i4 = R.id.rich_presence_title;
                                                    }
                                                } else {
                                                    i4 = R.id.rich_presence_time;
                                                }
                                            } else {
                                                str3 = "Missing required view with ID: ";
                                                i4 = R.id.rich_presence_primary_button;
                                            }
                                        } else {
                                            str3 = "Missing required view with ID: ";
                                            i4 = R.id.rich_presence_image_large_wrap;
                                        }
                                    } else {
                                        str3 = "Missing required view with ID: ";
                                        i4 = R.id.rich_presence_image_large_text;
                                    }
                                } else {
                                    str3 = "Missing required view with ID: ";
                                    i4 = R.id.rich_presence_image_large;
                                }
                            } else {
                                str3 = "Missing required view with ID: ";
                                i4 = R.id.rich_presence_header;
                            }
                        } else {
                            str3 = "Missing required view with ID: ";
                            i4 = R.id.rich_presence_details;
                        }
                    } else {
                        str3 = "Missing required view with ID: ";
                        i4 = R.id.rich_presence_container_data;
                    }
                } else {
                    str3 = "Missing required view with ID: ";
                    i4 = R.id.image_bottom_guideline;
                }
            } else {
                str3 = "Missing required view with ID: ";
                i4 = R.id.barrier;
            }
            throw new NullPointerException(str3.concat(viewInflate4.getResources().getResourceName(i4)));
            return viewHolderPlatformRichPresence;
        }

        private final int getRPViewHolderType(Activity activity, StreamContext streamContext) {
            if (streamContext != null) {
                return 4;
            }
            if (activity != null && ActivityUtils.isGamePlatform(activity)) {
                return 3;
            }
            if (activity != null && ActivityUtils.isGameActivity(activity)) {
                return 1;
            }
            if (activity == null || !ActivityUtils.isSpotifyActivity(activity)) {
                return (activity == null || !ActivityUtils.isStageChannelActivity(activity)) ? 0 : 5;
            }
            return 2;
        }

        public final ViewHolderUserRichPresence setRichPresence(ViewGroup parent, Activity activity, StreamContext streamContext, ViewHolderUserRichPresence oldViewHolder) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            int rPViewHolderType = getRPViewHolderType(activity, streamContext);
            if (oldViewHolder != null && rPViewHolderType == oldViewHolder.getRichPresenceType()) {
                return oldViewHolder;
            }
            parent.removeAllViews();
            return ViewHolderUserRichPresence.INSTANCE.createRPView(parent, rPViewHolderType);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.presence.ViewHolderUserRichPresence$configureUiTimestamp$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            ViewHolderUserRichPresence.this.perSecondTimerSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.presence.ViewHolderUserRichPresence$configureUiTimestamp$2, reason: invalid class name */
    /* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Activity $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Activity activity) {
            super(1);
            this.$model = activity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            ViewHolderUserRichPresence.this.setTimeTextViews(this.$model.getTimestamps());
        }
    }

    public ViewHolderUserRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, Button button, Button button2, int i) {
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView4, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        this.root = view;
        this.richPresenceImageLarge = simpleDraweeView;
        this.richPresenceImageSmall = simpleDraweeView2;
        this.richPresenceHeader = textView;
        this.richPresenceTitle = textView2;
        this.richPresenceDetails = textView3;
        this.richPresenceTime = textView4;
        this.richPresenceState = textView5;
        this.richPresenceTextContainer = view2;
        this.richPresencePrimaryButton = button;
        this.richPresenceSecondaryButton = button2;
        this.richPresenceType = i;
    }

    private final void handleActivityCustomButtonClick(Context applicationContext, User user, Activity activity, int buttonIndex) {
        String sessionId;
        Long applicationId;
        if (user != null) {
            long id2 = user.getId();
            if (activity == null || (sessionId = activity.getSessionId()) == null || (applicationId = activity.getApplicationId()) == null) {
                return;
            }
            long jLongValue = applicationId.longValue();
            Function5<? super Context, ? super Long, ? super String, ? super Long, ? super Integer, Unit> function5 = this.onActivityCustomButtonClicked;
            if (function5 != null) {
                function5.invoke(applicationContext, Long.valueOf(id2), sessionId, Long.valueOf(jLongValue), Integer.valueOf(buttonIndex));
            }
        }
    }

    public static /* synthetic */ void setImageAndVisibilityBy$default(ViewHolderUserRichPresence viewHolderUserRichPresence, ImageView imageView, String str, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setImageAndVisibilityBy");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        viewHolderUserRichPresence.setImageAndVisibilityBy(imageView, str, z2);
    }

    public static final ViewHolderUserRichPresence setRichPresence(ViewGroup viewGroup, Activity activity, StreamContext streamContext, ViewHolderUserRichPresence viewHolderUserRichPresence) {
        return INSTANCE.setRichPresence(viewGroup, activity, streamContext, viewHolderUserRichPresence);
    }

    @MainThread
    public void configureAssetUi(Activity model, StreamContext streamContext) {
        String str;
        String str2 = null;
        ActivityAssets assets = model != null ? model.getAssets() : null;
        if (assets == null) {
            this.richPresenceImageLarge.setVisibility(8);
            SimpleDraweeView simpleDraweeView = this.richPresenceImageSmall;
            if (simpleDraweeView != null) {
                simpleDraweeView.setVisibility(8);
                return;
            }
            return;
        }
        Long applicationId = model.getApplicationId();
        String largeImage = assets.getLargeImage();
        String assetImage$default = largeImage != null ? IconUtils.getAssetImage$default(IconUtils.INSTANCE, applicationId, largeImage, 0, 4, null) : null;
        String largeText = assets.getLargeText();
        String smallImage = assets.getSmallImage();
        String assetImage$default2 = smallImage != null ? IconUtils.getAssetImage$default(IconUtils.INSTANCE, applicationId, smallImage, 0, 4, null) : null;
        String smallText = assets.getSmallText();
        if (assetImage$default2 == null || assetImage$default != null) {
            str2 = assetImage$default2;
            str = assetImage$default;
        } else {
            str = assetImage$default2;
            largeText = smallText;
            smallText = null;
        }
        setImageAndVisibilityBy$default(this, this.richPresenceImageLarge, str, false, 2, null);
        this.richPresenceImageLarge.setContentDescription(largeText);
        SimpleDraweeView simpleDraweeView2 = this.richPresenceImageSmall;
        if (simpleDraweeView2 != null) {
            setImageAndVisibilityBy(simpleDraweeView2, str2, true);
        }
        SimpleDraweeView simpleDraweeView3 = this.richPresenceImageSmall;
        if (simpleDraweeView3 != null) {
            simpleDraweeView3.setContentDescription(smallText);
        }
    }

    @MainThread
    public void configureCustomButtonsUi(final User user, final Activity activity, final Context applicationContext) {
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        List<String> listC = activity != null ? activity.c() : null;
        final int i = 0;
        for (Object obj : Collections2.listOf((Object[]) new Button[]{this.richPresencePrimaryButton, this.richPresenceSecondaryButton})) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            Button button = (Button) obj;
            String str = listC != null ? (String) _Collections.getOrNull(listC, i) : null;
            if (str != null) {
                if (button != null) {
                    button.setText(str);
                }
                if (button != null) {
                    ViewKt.setVisible(button, true);
                }
                if (button != null) {
                    final List<String> list = listC;
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.presence.ViewHolderUserRichPresence$configureCustomButtonsUi$$inlined$forEachIndexed$lambda$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.handleActivityCustomButtonClick(applicationContext, user, activity, i);
                        }
                    });
                }
            } else if (button != null) {
                ViewKt.setVisible(button, false);
            }
            i = i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004a  */
    public void configureTextUi(Activity model, StreamContext streamContext) {
        String string;
        CharSequence charSequenceB;
        Context context;
        if (model == null) {
            return;
        }
        String state = model.getState();
        if (state != null) {
            ActivityParty party = model.getParty();
            if (party != null) {
                PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
                charSequenceB = (presenceUtils.getMaxSize(party) == 0 || (context = this.root.getContext()) == null) ? null : FormatUtils.b(context, R.string.user_activity_state_size, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
                if (charSequenceB == null) {
                    charSequenceB = "";
                }
            } else {
                charSequenceB = "";
            }
            String str = state + ' ' + charSequenceB;
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            string = Strings4.trim(str).toString();
        } else {
            string = null;
        }
        TextView textView = this.richPresenceHeader;
        Context context2 = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        textView.setText(PresenceUtils.getActivityHeader(context2, model));
        this.richPresenceTitle.setText(model.getDetails());
        TextView textView2 = this.richPresenceDetails;
        if (textView2 != null) {
            ViewExtensions.setTextAndVisibilityBy(textView2, string);
        }
        TextView textView3 = this.richPresenceState;
        if (textView3 != null) {
            ActivityAssets assets = model.getAssets();
            ViewExtensions.setTextAndVisibilityBy(textView3, assets != null ? assets.getLargeText() : null);
        }
        TextView textView4 = this.richPresenceTime;
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(textView4, timestamps != null ? friendlyTime(timestamps) : null);
    }

    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Activity primaryActivity = richPresence != null ? richPresence.getPrimaryActivity() : null;
        if (streamContext == null && primaryActivity == null) {
            this.root.setVisibility(8);
            return;
        }
        this.root.setVisibility(0);
        configureTextUi(primaryActivity, streamContext);
        this.richPresenceTextContainer.setSelected(true);
        configureAssetUi(primaryActivity, streamContext);
        configureCustomButtonsUi(user, primaryActivity, applicationContext);
    }

    @MainThread
    public void configureUiTimestamp(Activity model, AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        if (model != null && this.root.getVisibility() == 0) {
            ActivityTimestamps timestamps = model.getTimestamps();
            if ((timestamps != null ? friendlyTime(timestamps) : null) != null) {
                if (this.perSecondTimerSubscription == null) {
                    Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
                    Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n          .in…0L, 1L, TimeUnit.SECONDS)");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableE, appComponent, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(model));
                    return;
                }
                return;
            }
        }
        disposeTimer();
    }

    public void disposeSubscriptions() {
        disposeTimer();
    }

    @MainThread
    public final void disposeTimer() {
        Subscription subscription = this.perSecondTimerSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.perSecondTimerSubscription = null;
    }

    public final CharSequence friendlyTime(ActivityTimestamps activityTimestamps) {
        Intrinsics3.checkNotNullParameter(activityTimestamps, "$this$friendlyTime");
        if (activityTimestamps.b() > 0) {
            return TimeUtils.INSTANCE.toFriendlyString(ClockFactory.get().currentTimeMillis(), activityTimestamps.b(), getString(R.string.user_activity_timestamp_end_simple), "timeDelta");
        }
        if (activityTimestamps.c() > 0) {
            return TimeUtils.INSTANCE.toFriendlyString(activityTimestamps.c(), ClockFactory.get().currentTimeMillis(), getString(R.string.user_activity_timestamp_start_simple), "timeDelta");
        }
        return null;
    }

    public final TextView getRichPresenceDetails() {
        return this.richPresenceDetails;
    }

    public final TextView getRichPresenceHeader() {
        return this.richPresenceHeader;
    }

    public final SimpleDraweeView getRichPresenceImageLarge() {
        return this.richPresenceImageLarge;
    }

    public final SimpleDraweeView getRichPresenceImageSmall() {
        return this.richPresenceImageSmall;
    }

    public final Button getRichPresencePrimaryButton() {
        return this.richPresencePrimaryButton;
    }

    public final Button getRichPresenceSecondaryButton() {
        return this.richPresenceSecondaryButton;
    }

    public final TextView getRichPresenceState() {
        return this.richPresenceState;
    }

    public final View getRichPresenceTextContainer() {
        return this.richPresenceTextContainer;
    }

    public final TextView getRichPresenceTime() {
        return this.richPresenceTime;
    }

    public final TextView getRichPresenceTitle() {
        return this.richPresenceTitle;
    }

    public final int getRichPresenceType() {
        return this.richPresenceType;
    }

    public final View getRoot() {
        return this.root;
    }

    public final String getString(@StringRes int stringId) {
        Context context = this.root.getContext();
        if (context != null) {
            return context.getString(stringId);
        }
        return null;
    }

    public final void setImageAndVisibilityBy(ImageView imageView, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$setImageAndVisibilityBy");
        MGImages.setImage$default(imageView, str, 0, 0, z2, null, null, 108, null);
        imageView.setVisibility((str == null || StringsJVM.isBlank(str)) ^ true ? 0 : 8);
    }

    public final void setOnActivityCustomButtonClicked(Function5<? super Context, ? super Long, ? super String, ? super Long, ? super Integer, Unit> newOnActivityCustomButtonClicked) {
        Intrinsics3.checkNotNullParameter(newOnActivityCustomButtonClicked, "newOnActivityCustomButtonClicked");
        this.onActivityCustomButtonClicked = newOnActivityCustomButtonClicked;
    }

    public void setTimeTextViews(ActivityTimestamps timestamps) {
        ViewExtensions.setTextAndVisibilityBy(this.richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
    }

    public /* synthetic */ ViewHolderUserRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, Button button, Button button2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, textView5, view2, button, button2, (i2 & 2048) != 0 ? 0 : i);
    }
}
