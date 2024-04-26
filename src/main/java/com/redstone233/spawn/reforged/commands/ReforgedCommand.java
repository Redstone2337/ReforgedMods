package com.redstone233.spawn.reforged.commands;

import org.joml.Math;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class ReforgedCommand {

    public static String[] typeArray = { "trifunc", "deffunc" };
    public static String[] nameArray = { "sin", "cos", "tan", "asin", "acos", "atan" };
    public static String[] infoArray = { "abs", "sqrt", "cbrt", "ceil", "floor", "round", "max", "min" };

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("reforged")
        .requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.literal("nbt")
            .then(CommandManager.argument("slot", IntegerArgumentType.integer())
                .executes(run -> getNbts(run.getSource(), 
                    IntegerArgumentType.getInteger(run, "slot"), 
                        run.getSource().getPlayer()
                    )
                )
            ) 
        ).requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.literal("math")
            .then(CommandManager.literal(typeArray[0])
                .then(CommandManager.literal(nameArray[0])
                    .then(CommandManager.argument("angle", DoubleArgumentType.doubleArg())
                        .executes(run -> mathTrig(run.getSource(), nameArray[1],
                            DoubleArgumentType.getDouble(run, "angle")))
                        )
                    )
                .then(CommandManager.literal(nameArray[1])
                    .then(CommandManager.argument("angle", DoubleArgumentType.doubleArg())
                        .executes(run -> mathTrig(run.getSource(), nameArray[1],
                            DoubleArgumentType.getDouble(run, "angle")))
                        )
                    )
                .then(CommandManager.literal(nameArray[2])
                    .then(CommandManager.argument("angle", DoubleArgumentType.doubleArg())
                        .executes(run -> mathTrig(run.getSource(), nameArray[2],
                            DoubleArgumentType.getDouble(run, "angle")))
                        )
                    )
                .then(CommandManager.literal(nameArray[3])
                    .then(CommandManager.argument("angle", DoubleArgumentType.doubleArg())
                        .executes(run -> mathTrig(run.getSource(), nameArray[3],
                            DoubleArgumentType.getDouble(run, "angle")))
                        )
                    )
                .then(CommandManager.literal(nameArray[4])
                    .then(CommandManager.argument("angle", DoubleArgumentType.doubleArg())
                        .executes(run -> mathTrig(run.getSource(), nameArray[4],
                            DoubleArgumentType.getDouble(run, "angle")))
                        )
                    )
                .then(CommandManager.literal(nameArray[5])
                    .then(CommandManager.argument("angle", DoubleArgumentType.doubleArg())
                        .executes(run -> mathTrig(run.getSource(), nameArray[5],
                            DoubleArgumentType.getDouble(run, "angle")))
                        )
                    )
                )
            .requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.literal(typeArray[1])
                .then(CommandManager.literal(infoArray[0])
                    .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> mathDefe(run.getSource(), infoArray[0],
                            DoubleArgumentType.getDouble(run, "value")))
                        )
                    )
                .then(CommandManager.literal(infoArray[1])
                    .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> mathDefe(run.getSource(), infoArray[1],
                            DoubleArgumentType.getDouble(run, "value")))
                        )
                    )
                .then(CommandManager.literal(infoArray[2])
                    .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> mathDefe(run.getSource(), infoArray[2],
                            DoubleArgumentType.getDouble(run, "value")))
                        )
                    )
                .then(CommandManager.literal(infoArray[3])
                    .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> mathDefe(run.getSource(), infoArray[3],
                            DoubleArgumentType.getDouble(run, "value")))
                        )
                    )
                .then(CommandManager.literal(infoArray[4])
                    .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> mathDefe(run.getSource(), infoArray[4],
                            DoubleArgumentType.getDouble(run, "value")))
                        )
                    )
                .then(CommandManager.literal(infoArray[5])
                    .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> mathDefe(run.getSource(), infoArray[5],
                            DoubleArgumentType.getDouble(run, "value")))
                    )
                )
                .then(CommandManager.literal(infoArray[6])
                    .then(CommandManager.literal("double")
                        .then(CommandManager.argument("value1", 
                            DoubleArgumentType.doubleArg())
                                .then(CommandManager.argument("value2", 
                                    DoubleArgumentType.doubleArg())
                                .executes(run -> doubleMaxValue(run.getSource(),
                                    DoubleArgumentType.getDouble(run, "value1"), 
                                    DoubleArgumentType.getDouble(run, "value2"))
                                )
                            )
                        )
                    )
                    .then(CommandManager.literal("float")
                        .then(CommandManager.argument("value1", 
                            FloatArgumentType.floatArg())
                                .then(CommandManager.argument("value2", 
                                    FloatArgumentType.floatArg())
                                .executes(run -> floatMaxValue(run.getSource(),
                                    FloatArgumentType.getFloat(run, "value1"), 
                                    FloatArgumentType.getFloat(run, "value2"))
                                )
                            )
                        )
                    )
                    .then(CommandManager.literal("int")
                        .then(CommandManager.argument("value1", 
                            IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", 
                                    IntegerArgumentType.integer())
                                .executes(run -> intMaxValue(run.getSource(),
                                    IntegerArgumentType.getInteger(run, "value1"), 
                                    IntegerArgumentType.getInteger(run, "value2"))
                                )
                            )
                        )
                    )
                )
                .then(CommandManager.literal(infoArray[7])
                    .then(CommandManager.literal("double")
                        .then(CommandManager.argument("value1", 
                            DoubleArgumentType.doubleArg())
                                .then(CommandManager.argument("value2", 
                                    DoubleArgumentType.doubleArg())
                                .executes(run -> doubleMinValue(run.getSource(),
                                    DoubleArgumentType.getDouble(run, "value1"), 
                                    DoubleArgumentType.getDouble(run, "value2"))
                                )
                            )
                        )
                    )
                    .then(CommandManager.literal("float")
                        .then(CommandManager.argument("value1", 
                            FloatArgumentType.floatArg())
                                .then(CommandManager.argument("value2", 
                                    FloatArgumentType.floatArg())
                                .executes(run -> floatMinValue(run.getSource(),
                                    FloatArgumentType.getFloat(run, "value1"), 
                                    FloatArgumentType.getFloat(run, "value2"))
                                )
                            )
                        )
                    )
                    .then(CommandManager.literal("int")
                        .then(CommandManager.argument("value1", 
                            IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", 
                                    IntegerArgumentType.integer())
                                .executes(run -> intMinValue(run.getSource(),
                                    IntegerArgumentType.getInteger(run, "value1"), 
                                    IntegerArgumentType.getInteger(run, "value2"))
                                )
                            )
                        )
                    )
                )
            )
        );
    }

    private static int mathTrig(ServerCommandSource source,String type,double angle) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        double value = Math.toRadians(angle);
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (angle == value) {
                    if (type == nameArray[0]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.sin",angle,Math.sin(value)));
                    }
                    if (type == nameArray[1]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.cos",angle,Math.cos(value)));
                    }
                    if (type == nameArray[2]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.tan",angle,Math.tan(value)));
                    }
                    if (type == nameArray[3]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.asin",angle,Math.asin(value)));
                    }
                    if (type == nameArray[4]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.acos",angle,Math.acos(value)));
                    }
                    if (type == nameArray[5]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.atan",angle,Math.asin(angle)));
                    }
                    if (type == null || angle == 0) {
                        source.sendError(Text.translatable("commands.reforged.math.fail"));
                        return 0;
                    }
                }
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_EXCEPTION_TYPE.create();
            }
            source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true);
        } 
        return 1;
    }

    private static int mathDefe(ServerCommandSource source,String type,double value) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
           if (source instanceof ServerCommandSource) { 
                if (value < 0) {
                    if (type == infoArray[0]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.abs",value,Math.abs(value)));
                    }
                    if (type == infoArray[1]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.sqrt",value,Math.sqrt(value)));
                    }
                    if (type == infoArray[2]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.cbrt",value));
                    }
                    if (type == infoArray[3]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.ceil",value,Math.ceil(value)));
                    }
                    if (type == infoArray[4]) {
                        player.sendMessage(Text.translatable("commands.reforged.math.floor",value,Math.floor(value)));
                    }
                    if (type == infoArray[5]) {
                    player.sendMessage(Text.translatable("commands.reforged.math.round",value,Math.round(value)));
                    }
                    if (type == null || value == 0) {
                        source.sendError(Text.translatable("commands.reforged.math.fail"));
            return 0;
                    }
                }
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_EXCEPTION_TYPE.create();
            }
            source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true);
        }
        return 1;
    }

    private static int getNbts(ServerCommandSource source, int slot, PlayerEntity player) throws CommandSyntaxException {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        ItemStack stack = player.getInventory().getStack(slot);
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (slot >= 0 && slot <= 40) {
                    if (stack.hasNbt()) {
                        assert stack.getNbt() != null;
                        String s = stack.getNbt().toString();
                        player.sendMessage((Text) new LiteralMessage(s));
                    } else {
                        player.sendMessage(Text.translatable("commands.nbt.slot.error"));
                    }
                } else if (slot < 0) {
                    player.sendMessage(Text.translatable("commands.nbt.slot.small", slot));
                } else if (slot > 40) {
                    player.sendMessage(Text.translatable("commands.nbt.slot.big", slot));
                } else {
                    source.sendError(Text.translatable("commands.nbt.fail"));
                    return 0;
                }
                if (!source.getServer().isDedicated()) {
                    throw ModCommands.TRSM_COMMAND_EXCEPTION_TYPE.create();
                }
                source.sendFeedback(() -> Text.translatable("commands.nbt.success"), true);
            }   
        }
        return 1;
    }

    private static int doubleMaxValue(ServerCommandSource source,double value1,double value2) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (value1 != 0 && value2 != 0) {
                    player.sendMessage(Text.translatable("commands.reforged.math.double.max",value1,value2,Math.max(value1, value2))); 
                } else {
                    source.sendError(Text.translatable("commands.reforged.math.fail"));
                    return 0;
                }
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_EXCEPTION_TYPE.create();
            }
            source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true); 
        } 
        return 1;
    }

    private static int floatMaxValue(ServerCommandSource source,float value1,float value2) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (value1 != 0 && value2 != 0) {
               player.sendMessage(Text.translatable("commands.reforged.math.float.max",value1,value2,Math.max(value1, value2))); 
            } else {
                source.sendError(Text.translatable("commands.reforged.math.fail"));
                return 0;
            }
        }
        if (!source.getServer().isDedicated()) {
            throw ModCommands.TRSM_COMMAND_EXCEPTION_TYPE.create();
        }
        source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true); 
    } 
    return 1;
}

    private static int intMaxValue(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
        if (source instanceof ServerCommandSource) {
                if (value1 != 0 && value2 != 0) {
                    player.sendMessage(Text.translatable("commands.reforged.math.int.max",value1,value2,Math.max(value1, value2))); 
                } else {
                    source.sendError(Text.translatable("commands.reforged.math.fail"));
                    return 0;
                }
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_WORONG_BE_INTEGRATED.create();
            }
            source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true);
        } 
        return 1;
    }

    private static int doubleMinValue(ServerCommandSource source,double value1,double value2) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (value1 != 0 && value2 != 0) {
                    player.sendMessage(Text.translatable("commands.reforged.math.double.min",value1,value2,Math.min(value1, value2))); 
                } else {
                    source.sendError(Text.translatable("commands.reforged.math.fail"));
                    return 0;
                }
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_EXCEPTION_TYPE.create();
            }
            source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true);
        } 
        return 1;
    }

    private static int floatMinValue(ServerCommandSource source,float value1,float value2) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (value1 != 0 && value2 != 0) {
                    player.sendMessage(Text.translatable("commands.reforged.math.float.min",value1,value2,Math.min(value1, value2))); 
                } else {
                    source.sendError(Text.translatable("commands.reforged.math.fail"));
                    return 0;
                }
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_EXCEPTION_TYPE.create();
            }
            source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true);
        }
        return 1;
    }

    private static int intMinValue(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (value1 != 0 && value2 != 0) {
                    player.sendMessage(Text.translatable("commands.reforged.math.int.min",value1,value2,Math.min(value1, value2))); 
                } else {
                    source.sendError(Text.translatable("commands.reforged.math.fail"));
                    return 0;
                }
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_WORONG_BE_INTEGRATED.create();
            }
            source.sendFeedback(() -> Text.translatable("commands.reforged.math.success"), true);   
        }
        return 1;
    }
}
