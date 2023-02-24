import subprocess
import sys

def limpa(textos):
    funcoes = []
    for texto in textos:
        if 'PUSH' in texto or 'MULT' in texto or 'DIV' in texto or 'SUM' in texto or 'SUB' in texto or 'PRINT' in texto:
            funcoes.append(texto)
    return funcoes

def interpretador(funcoes):
    pilha = []

    for func in funcoes:
        print(pilha)
        print(func)
        if 'PUSH' in func:
            pilha.append(int(func.split(' ')[1]))
            continue
        if 'MULT' in func:
            pilha.append(pilha.pop() * pilha.pop())
            continue
        if 'DIV' in func:
            pilha.append(pilha.pop(-2) / pilha.pop()) # -2 para pegar o penultimo elemento pois o ultimo é o divisor
            continue
        if 'SUM' in func:
            pilha.append(pilha.pop() + pilha.pop())
            continue
        if 'SUB' in func:
            pilha.append(pilha.pop(-2) - pilha.pop()) # -2 para pegar o penultimo elemento pois o ultimo é o subtraendo
            continue
        if 'PRINT' in func:
            print(pilha.pop())
            continue

if __name__ == '__main__':
    output = subprocess.check_output(['java', 'Compilador', f'{sys.argv[1]}']).decode('utf-8').split('\n')
    funcoes = limpa(output)
    interpretador(funcoes)
    