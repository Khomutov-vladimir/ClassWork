# OBSERVATIONS.md – חדר בריחה ב-Logcat

**קורס:** פיתוח Android (Java), כיתה י"א – כפר הנוער אלוני יצחק
**שיעור:** יום שני 5.10.2026 | **הגשה:** שבת 24.10.2026, 23:59

## פרטי הזוג

| שם 1         | שם 2 |
|:-------------| :--- |
| וובה חומוטוב | |

---

## חלק א': בורחים מהחדר (30 נק')

מלאו את הטבלה תוך כדי המשחק.

| מספר רמז | מה עשיתם כדי שהרמז יופיע           | המילה שמצאתם |
| :---: |:-----------------------------------| :--- |
| 1 | I've just run the app              | WELCOME |
| 2 | I've just exited the app           | BACK |
| 3 | It appeared when onStop was called | TO |
| 4 | I've just turned the screen        | ANDROID |

**הסיסמה:** `WELCOME BACK TO ANDROID`

**ברחנו?** (סמנו X)
- [x] כן, הופיע `ESCAPED!`
- [ ] עדיין לא

---

## חלק ג': תצפיות על מחזור החיים (30 נק')

**הנחיות:**
1. ודאו שהוספתם את כל 6 שורות ה-`Log.d(MY_TAG, ...)` ל-`MainActivity.java` (חלק ב').
2. ב-Logcat החילו את המסנן `tag:MY_LIFECYCLE`.
3. לפני כל ניסוי נקו את Logcat (סמל הפח).
4. בצעו את הפעולה, ורשמו את ההודעות **בסדר המדויק** שבו הופיעו. השאירו ריקות שורות שלא צריך.

### ניסוי 1: הפעלה ראשונה
*מה עשיתם:* לחצנו Run באנדרואיד סטודיו והפעלנו את האפליקציה לראשונה.

*הודעות MY_LIFECYCLE לפי הסדר:*
1. onCreate
2. onStart
3. onResume
4.
5.
6.

---

### ניסוי 2: כפתור Home
*מה עשיתם:* לחצנו על כפתור Home כשהאפליקציה פתוחה.

*הודעות MY_LIFECYCLE לפי הסדר:*
1. onPause
2. onStop
3.
4.
5.
6.

---

### ניסוי 3: חזרה לאפליקציה
*מה עשיתם:* חזרנו לאפליקציה על ידי הקשה על סמל האפליקציה / מרשימת האפליקציות האחרונות.

*הודעות MY_LIFECYCLE לפי הסדר:*
1. onStart
2. onResume
3.
4.
5.
6.

---

### ניסוי 4: סיבוב מסך
*מה עשיתם:* לחצנו Ctrl + Right באמולטור כדי לסובב את המסך.

*הודעות MY_LIFECYCLE לפי הסדר:*
1. onPause
2. onStop
3. onDestroy
4. onCreate
5. onStart
6. onResume

---

### ניסוי 5: כפתור Back
*מה עשיתם:* לחצנו על כפתור Back כשהאפליקציה פתוחה.

*הודעות MY_LIFECYCLE לפי הסדר:*
1. onPause
2. onStop
3. onDestroy
4.
5.
6.

---

## שאלות רפלקציה

1. **מה הפתיע אתכם בניסוי סיבוב המסך?** (מה ציפיתם לראות, ומה ראיתם בפועל?)

   > It seems like Android not only stops the activity, but also destroys it and re-creates it.
2. **למה רמז 3 לא הופיע בסינון הראשון שלכם ב-Logcat? איך מצאתם אותו בסוף?**

   > We didn't see the clue, because it's held under another tag.
---

## בונוס: המונה ששורד סיבוב (+10 נק')

*מה שיניתם:* (איזה קוד הוספתם או שיניתם כדי שהמונה לא יתאפס בסיבוב מסך?)

> I've added the variable save feature via onSaveInstanceState.

*למה זה עובד:* (הסבירו במילים שלכם, והזכירו את `onSaveInstanceState` ואת המפתח `"counter"`.)

> Before the destruction of the activity the variable counter is being saved into savedInstanceState. After re-creating the activity counter refreshes from the saved value and the visible text updates. 