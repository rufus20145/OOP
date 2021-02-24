/**
 * @file main.c
 * @author rufus20145 (ivan20027749@gmail.com)
 * @brief ДЗ 1: Нужно создать новую строку из заданной, удалив из нее все повторяющиеся символы.
 * @version 0.1
 * @date 2021-02-15
 *
 * @copyright Copyright (c) 2021
 *
 */

#define STRINGSIZE 1024
#define NUMBER_OF_SYMBOLS 256

#include <stdio.h>
#include <string.h>
#include "input.c"

int main()
{
    int inputErrorCode, stringSize, currDigit = 0;
    int foundSymbols[NUMBER_OF_SYMBOLS];
    char digit;
    char *string;

    for (int i = 0; i < NUMBER_OF_SYMBOLS; i++)
    {
        foundSymbols[i] = 0;
    }

    fputs("Enter string size: ", stdout);
    do
    {
        inputErrorCode = enterNumber(&stringSize);

    } while (1 == inputErrorCode);
    string = (char *)calloc(stringSize, sizeof(char));

    fputs("Now enter the line:", stdout);

    for (int i = 0; i < stringSize; i++)
    {
        digit = getchar();
        if (digit != '\n')
        {
            if (!foundSymbols[(int)digit])
            {
                string[currDigit] = digit;
                currDigit++;
            }
            foundSymbols[(int)digit]++;
        }
        else
        {
            break;
        }
    }

    for (int i = 0; i < stringSize; i++)
    {
        putchar(string[i]);
    }
    return 0;
}
