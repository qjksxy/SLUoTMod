package sluot.bread.util;

import net.minecraft.item.Item;
import sluot.bread.item.ModItems;

public class WeaponItem {
    public static final String JINGSHUI = "静水流涌之辉";
    public static final String HUMO = "护摩之杖";
    public static final String SIWANG = "死亡之舞";

    // 武器及精炼等级
    public String weaponName = "";
    public int rank = 0;

    public static WeaponItem getModWeapon(Item item) {
        WeaponItem weaponItem = new WeaponItem();
        if (ModItems.JINGSHUI_ITEMS.contains(item)) {
            weaponItem.weaponName = JINGSHUI;
            weaponItem.rank = ModItems.JINGSHUI_ITEMS.indexOf(item) + 1;
        } else if (ModItems.HUMO_ITEMS.contains(item)) {
            weaponItem.weaponName = HUMO;
            weaponItem.rank = ModItems.HUMO_ITEMS.indexOf(item) + 1;
        } else if (ModItems.SIWANG_ITEMS.contains(item)) {
            weaponItem.weaponName = SIWANG;
            weaponItem.rank = ModItems.SIWANG_ITEMS.indexOf(item) + 1;
        }
        return weaponItem;
    }
}
