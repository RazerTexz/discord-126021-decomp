package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            int i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = i4;
            i3 = 2;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0173  */
    /* JADX WARN: Code duplicated, block: B:102:0x0194  */
    /* JADX WARN: Code duplicated, block: B:172:0x02df  */
    /* JADX WARN: Code duplicated, block: B:25:0x003e A[PHI: r14 r15
      0x003e: PHI (r14v3 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x003e: PHI (r15v3 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0040 A[PHI: r14 r15
      0x0040: PHI (r14v28 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0040: PHI (r15v35 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x016a  */
    /* JADX WARN: Code duplicated, block: B:98:0x016d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.solver.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z2;
        boolean z3;
        boolean z4;
        Object obj;
        int i3;
        int i4;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ?? r5;
        SolverVariable solverVariable5;
        float f;
        int size;
        ConstraintAnchor constraintAnchor3;
        int i5;
        ConstraintWidget constraintWidget = chainHead.mFirst;
        ConstraintWidget constraintWidget2 = chainHead.mLast;
        ConstraintWidget constraintWidget3 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget4 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        boolean z5 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            int i6 = constraintWidget5.mHorizontalChainStyle;
            z2 = i6 == 0;
            z3 = i6 == 1;
            if (i6 == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            int i7 = constraintWidget5.mVerticalChainStyle;
            z2 = i7 == 0;
            z3 = i7 == 1;
            if (i7 == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        ?? r7 = constraintWidget;
        boolean z6 = false;
        while (true) {
            obj = null;
            if (z6) {
                break;
            }
            ConstraintAnchor constraintAnchor4 = r7.mListAnchors[i2];
            int i8 = z4 ? 1 : 4;
            int margin = constraintAnchor4.getMargin();
            float f3 = f2;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = r7.mListDimensionBehaviors[i];
            boolean z7 = z6;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z8 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && r7.mResolvedMatchConstraintDefault[i] == 0;
            ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
            if (constraintAnchor5 != null && r7 != constraintWidget) {
                margin = constraintAnchor5.getMargin() + margin;
            }
            int i9 = margin;
            if (z4 && r7 != constraintWidget && r7 != constraintWidget3) {
                i8 = 8;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchor4.mTarget;
            if (constraintAnchor6 != null) {
                if (r7 == constraintWidget3) {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i9, 6);
                } else {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i9, 8);
                }
                linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor4.mTarget.mSolverVariable, i9, (!z8 || z4) ? i8 : 5);
            } else {
                constraintWidget5 = constraintWidget5;
                constraintWidget = constraintWidget;
            }
            if (z5) {
                if (r7.getVisibility() == 8 || r7.mListDimensionBehaviors[i] != constraintWidget$DimensionBehaviour2) {
                    i5 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r7.mListAnchors;
                    i5 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r7.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i5, 8);
            }
            ConstraintAnchor constraintAnchor7 = r7.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor7.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget6.mListAnchors;
                if (constraintAnchorArr2[i2].mTarget != null && constraintAnchorArr2[i2].mTarget.mOwner == r7) {
                    obj = constraintWidget6;
                }
            }
            if (obj != null) {
                r7 = obj;
                z6 = z7;
            } else {
                z6 = true;
            }
            z2 = z2;
            f2 = f3;
            z3 = z3;
            constraintWidget5 = constraintWidget5;
            constraintWidget = constraintWidget;
            r7 = r7;
        }
        ConstraintWidget constraintWidget7 = constraintWidget5;
        float f4 = f2;
        ConstraintWidget constraintWidget8 = constraintWidget;
        boolean z9 = z2;
        boolean z10 = z3;
        if (constraintWidget4 != null) {
            int i10 = i2 + 1;
            if (constraintWidget2.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget4.mListAnchors[i10];
                if ((constraintWidget4.mListDimensionBehaviors[i] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.mResolvedMatchConstraintDefault[i] == 0) && !z4) {
                    ConstraintAnchor constraintAnchor9 = constraintAnchor8.mTarget;
                    if (constraintAnchor9.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor9.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                    } else if (z4) {
                        constraintAnchor3 = constraintAnchor8.mTarget;
                        if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor8.getMargin(), 4);
                        }
                    }
                } else if (z4) {
                    constraintAnchor3 = constraintAnchor8.mTarget;
                    if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor8.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget2.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
            }
        }
        if (z5) {
            int i11 = i2 + 1;
            SolverVariable solverVariable6 = constraintWidgetContainer.mListAnchors[i11].mSolverVariable;
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
            linearSystem.addGreaterThan(solverVariable6, constraintAnchorArr3[i11].mSolverVariable, constraintAnchorArr3[i11].getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f5 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
            float f6 = 0.0f;
            ConstraintWidget constraintWidget9 = null;
            int i12 = 0;
            float f7 = 0.0f;
            while (i12 < size) {
                ConstraintWidget constraintWidget10 = arrayList.get(i12);
                float f8 = constraintWidget10.mWeight[i];
                if (f8 < f6) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget10.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr4[i2 + 1].mSolverVariable, constraintAnchorArr4[i2].mSolverVariable, 0, 4);
                    } else {
                        f8 = 1.0f;
                    }
                    arrayList = arrayList;
                    i12++;
                    arrayList = arrayList;
                    f6 = 0.0f;
                }
                if (f8 == f6) {
                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget10.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 8);
                    arrayList = arrayList;
                } else {
                    if (constraintWidget9 != null) {
                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget9.mListAnchors;
                        SolverVariable solverVariable7 = constraintAnchorArr6[i2].mSolverVariable;
                        int i13 = i2 + 1;
                        SolverVariable solverVariable8 = constraintAnchorArr6[i13].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget10.mListAnchors;
                        SolverVariable solverVariable9 = constraintAnchorArr7[i2].mSolverVariable;
                        SolverVariable solverVariable10 = constraintAnchorArr7[i13].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                    constraintWidget9 = constraintWidget10;
                    f7 = f8;
                }
                i12++;
                arrayList = arrayList;
                f6 = 0.0f;
            }
        }
        if (constraintWidget3 != null && (constraintWidget3 == constraintWidget4 || z4)) {
            ConstraintAnchor constraintAnchor10 = constraintWidget8.mListAnchors[i2];
            int i14 = i2 + 1;
            ConstraintAnchor constraintAnchor11 = constraintWidget2.mListAnchors[i14];
            ConstraintAnchor constraintAnchor12 = constraintAnchor10.mTarget;
            SolverVariable solverVariable11 = constraintAnchor12 != null ? constraintAnchor12.mSolverVariable : null;
            ConstraintAnchor constraintAnchor13 = constraintAnchor11.mTarget;
            SolverVariable solverVariable12 = constraintAnchor13 != null ? constraintAnchor13.mSolverVariable : null;
            ConstraintAnchor constraintAnchor14 = constraintWidget3.mListAnchors[i2];
            ConstraintAnchor constraintAnchor15 = constraintWidget4.mListAnchors[i14];
            if (solverVariable11 != null && solverVariable12 != null) {
                if (i == 0) {
                    f = constraintWidget7.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget7.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor14.mSolverVariable, solverVariable11, constraintAnchor14.getMargin(), f, solverVariable12, constraintAnchor15.mSolverVariable, constraintAnchor15.getMargin(), 7);
            }
        } else if (!z9 || constraintWidget3 == null) {
            int i15 = 8;
            if (z10 && constraintWidget3 != null) {
                int i16 = chainHead.mWidgetsMatchCount;
                boolean z11 = i16 > 0 && chainHead.mWidgetsCount == i16;
                ConstraintWidget constraintWidget11 = constraintWidget3;
                ConstraintWidget constraintWidget12 = constraintWidget11;
                while (constraintWidget11 != null) {
                    ConstraintWidget constraintWidget13 = constraintWidget11.mNextChainWidget[i];
                    while (constraintWidget13 != null && constraintWidget13.getVisibility() == i15) {
                        constraintWidget13 = constraintWidget13.mNextChainWidget[i];
                    }
                    if (constraintWidget11 == constraintWidget3 || constraintWidget11 == constraintWidget4 || constraintWidget13 == null) {
                        constraintWidget12 = constraintWidget12;
                        i4 = 8;
                    } else {
                        ConstraintWidget constraintWidget14 = constraintWidget13 == constraintWidget4 ? null : constraintWidget13;
                        ConstraintAnchor constraintAnchor16 = constraintWidget11.mListAnchors[i2];
                        SolverVariable solverVariable13 = constraintAnchor16.mSolverVariable;
                        ConstraintAnchor constraintAnchor17 = constraintAnchor16.mTarget;
                        if (constraintAnchor17 != null) {
                            SolverVariable solverVariable14 = constraintAnchor17.mSolverVariable;
                        }
                        int i17 = i2 + 1;
                        SolverVariable solverVariable15 = constraintWidget12.mListAnchors[i17].mSolverVariable;
                        int margin2 = constraintAnchor16.getMargin();
                        int margin3 = constraintWidget11.mListAnchors[i17].getMargin();
                        if (constraintWidget14 != null) {
                            constraintAnchor = constraintWidget14.mListAnchors[i2];
                            solverVariable = constraintAnchor.mSolverVariable;
                            ConstraintAnchor constraintAnchor18 = constraintAnchor.mTarget;
                            solverVariable2 = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
                        } else {
                            constraintAnchor = constraintWidget4.mListAnchors[i2];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget11.mListAnchors[i17].mSolverVariable;
                        }
                        int margin4 = constraintAnchor != null ? constraintAnchor.getMargin() + margin3 : margin3;
                        int margin5 = constraintWidget12.mListAnchors[i17].getMargin() + margin2;
                        int i18 = z11 ? 8 : 4;
                        if (solverVariable13 == null || solverVariable15 == null || solverVariable == null || solverVariable2 == null) {
                            i4 = 8;
                        } else {
                            i4 = 8;
                            linearSystem.addCentering(solverVariable13, solverVariable15, margin5, 0.5f, solverVariable, solverVariable2, margin4, i18);
                        }
                        constraintWidget13 = constraintWidget14;
                    }
                    if (constraintWidget11.getVisibility() == i4) {
                        constraintWidget11 = constraintWidget12;
                    }
                    constraintWidget12 = constraintWidget11;
                    i15 = 8;
                    constraintWidget11 = constraintWidget13;
                }
                ConstraintAnchor constraintAnchor19 = constraintWidget3.mListAnchors[i2];
                ConstraintAnchor constraintAnchor20 = constraintWidget8.mListAnchors[i2].mTarget;
                int i19 = i2 + 1;
                ConstraintAnchor constraintAnchor21 = constraintWidget4.mListAnchors[i19];
                ConstraintAnchor constraintAnchor22 = constraintWidget2.mListAnchors[i19].mTarget;
                if (constraintAnchor20 == null) {
                    i3 = 5;
                } else if (constraintWidget3 != constraintWidget4) {
                    i3 = 5;
                    linearSystem.addEquality(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 5);
                } else {
                    i3 = 5;
                    if (constraintAnchor22 != null) {
                        linearSystem.addCentering(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 0.5f, constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, constraintAnchor21.getMargin(), 5);
                    }
                }
                if (constraintAnchor22 != null && constraintWidget3 != constraintWidget4) {
                    linearSystem.addEquality(constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, -constraintAnchor21.getMargin(), i3);
                }
            }
        } else {
            int i20 = chainHead.mWidgetsMatchCount;
            boolean z12 = i20 > 0 && chainHead.mWidgetsCount == i20;
            ConstraintWidget constraintWidget15 = constraintWidget3;
            ConstraintWidget constraintWidget16 = constraintWidget15;
            while (constraintWidget15 != null) {
                ConstraintWidget constraintWidget17 = constraintWidget15.mNextChainWidget[i];
                while (constraintWidget17 != null && constraintWidget17.getVisibility() == 8) {
                    constraintWidget17 = constraintWidget17.mNextChainWidget[i];
                }
                if (constraintWidget17 != null || constraintWidget15 == constraintWidget4) {
                    ConstraintAnchor constraintAnchor23 = constraintWidget15.mListAnchors[i2];
                    SolverVariable solverVariable16 = constraintAnchor23.mSolverVariable;
                    ConstraintAnchor constraintAnchor24 = constraintAnchor23.mTarget;
                    SolverVariable solverVariable17 = constraintAnchor24 != null ? constraintAnchor24.mSolverVariable : null;
                    if (constraintWidget16 != constraintWidget15) {
                        solverVariable17 = constraintWidget16.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget15 == constraintWidget3 && constraintWidget16 == constraintWidget15) {
                        ConstraintAnchor[] constraintAnchorArr8 = constraintWidget8.mListAnchors;
                        solverVariable17 = constraintAnchorArr8[i2].mTarget != null ? constraintAnchorArr8[i2].mTarget.mSolverVariable : null;
                    }
                    int margin6 = constraintAnchor23.getMargin();
                    int i21 = i2 + 1;
                    int margin7 = constraintWidget15.mListAnchors[i21].getMargin();
                    if (constraintWidget17 != null) {
                        constraintAnchor2 = constraintWidget17.mListAnchors[i2];
                        SolverVariable solverVariable18 = constraintAnchor2.mSolverVariable;
                        solverVariable4 = constraintWidget15.mListAnchors[i21].mSolverVariable;
                        solverVariable3 = solverVariable18;
                    } else {
                        constraintAnchor2 = constraintWidget2.mListAnchors[i21].mTarget;
                        solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                        solverVariable4 = constraintWidget15.mListAnchors[i21].mSolverVariable;
                    }
                    if (constraintAnchor2 != null) {
                        margin7 += constraintAnchor2.getMargin();
                    }
                    if (constraintWidget16 != null) {
                        margin6 += constraintWidget16.mListAnchors[i21].getMargin();
                    }
                    if (solverVariable16 != null && solverVariable17 != null && solverVariable3 != null && solverVariable4 != null) {
                        if (constraintWidget15 == constraintWidget3) {
                            margin6 = constraintWidget3.mListAnchors[i2].getMargin();
                        }
                        linearSystem.addCentering(solverVariable16, solverVariable17, margin6, 0.5f, solverVariable3, solverVariable4, constraintWidget15 == constraintWidget4 ? constraintWidget4.mListAnchors[i21].getMargin() : margin7, z12 ? 8 : 5);
                    }
                }
                if (constraintWidget15.getVisibility() != 8) {
                    constraintWidget16 = constraintWidget15;
                }
                constraintWidget15 = constraintWidget17;
            }
        }
        if ((!z9 && !z10) || constraintWidget3 == null || constraintWidget3 == constraintWidget4) {
            return;
        }
        ConstraintAnchor[] constraintAnchorArr9 = constraintWidget3.mListAnchors;
        ConstraintAnchor constraintAnchor25 = constraintAnchorArr9[i2];
        int i22 = i2 + 1;
        ConstraintAnchor constraintAnchor26 = constraintWidget4.mListAnchors[i22];
        ConstraintAnchor constraintAnchor27 = constraintAnchor25.mTarget;
        SolverVariable solverVariable19 = constraintAnchor27 != null ? constraintAnchor27.mSolverVariable : null;
        ConstraintAnchor constraintAnchor28 = constraintAnchor26.mTarget;
        if (constraintAnchor28 != null) {
            solverVariable5 = constraintAnchor28.mSolverVariable;
        } else {
            r5 = 0;
        }
        if (constraintWidget2 != constraintWidget4) {
            ConstraintAnchor constraintAnchor29 = constraintWidget2.mListAnchors[i22].mTarget;
            if (constraintAnchor29 != null) {
                r5 = solverVariable5;
                obj = constraintAnchor29.mSolverVariable;
            }
            r5 = solverVariable5;
            r5 = obj;
        }
        if (constraintWidget3 == constraintWidget4) {
            constraintAnchor25 = constraintAnchorArr9[i2];
            constraintAnchor26 = constraintAnchorArr9[i22];
        }
        if (solverVariable19 == null || r5 == 0) {
            return;
        }
        linearSystem.addCentering(constraintAnchor25.mSolverVariable, solverVariable19, constraintAnchor25.getMargin(), 0.5f, r5, constraintAnchor26.mSolverVariable, constraintWidget4.mListAnchors[i22].getMargin(), 5);
    }
}
