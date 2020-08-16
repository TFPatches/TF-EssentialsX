package com.earth2me.essentials;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.staff.StaffList;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class TFMHandler
{
    private Essentials plugin;
    private TotalFreedomMod tfmPlugin;

    public TFMHandler()
    {
        this.plugin = Essentials.getPlugin(Essentials.class);
        this.tfmPlugin = null;
    }

    public TotalFreedomMod getTFM()
    {
        if (tfmPlugin == null)
        {
            try
            {
                final Plugin tfm = plugin.getServer().getPluginManager().getPlugin("TotalFreedomMod");
                if (tfm != null && tfm instanceof TotalFreedomMod)
                {
                    tfmPlugin = (TotalFreedomMod)tfm;
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return tfmPlugin;
    }

    public boolean isAdmin(User user)
    {
        return getTFM().sl.isAdmin(user.getBase());
    }

    public boolean isAdmin(CommandSender sender)
    {
        return getTFM().sl.isAdmin(sender);
    }

    public boolean isAdmin(Player player)
    {
        return getTFM().sl.isAdmin(player);
    }

    public boolean isVanished(User user)
    {
        return isVanished(user.getBase());
    }

    public boolean isVanished(Player player)
    {
        if (tfmPlugin != null)
        {
            getTFM();
        }
        return StaffList.vanished.contains(player.getName());
    }

    public void warning(String warning)
    {
        if (tfmPlugin != null)
        {
            getTFM();
        }
        FLog.warning(warning);
    }

    public void info(String info)
    {
        if (tfmPlugin != null)
        {
            getTFM();
        }
        FLog.info(info);
    }
}