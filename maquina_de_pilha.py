import subprocess
import sys

def limpa(textos):
    '''
    Função que limpa o output do compilador e retorna apenas as funções com os valores
    '''
    funcoes = []
    for texto in textos:
        if 'PUSH' in texto or 'MULT' in texto or 'DIV' in texto or 'SUM' in texto or 'SUB' in texto or 'PRINT' in texto:
            funcoes.append(texto)
    return funcoes

def maquina_de_pilha(funcoes):
    ''''
    Função que executa as funções da maquina de pilha
    '''
    pilha = []

    for func in funcoes:
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
    maquina_de_pilha(funcoes)
    